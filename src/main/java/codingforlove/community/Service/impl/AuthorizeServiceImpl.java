package codingforlove.community.Service.impl;

import codingforlove.community.DTO.AccessTokenDTO;
import codingforlove.community.DTO.UserDTO;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.User;
import codingforlove.community.Model.UserExample;
import codingforlove.community.Provider.GiteeProvider;
import codingforlove.community.Service.AuthorizeService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {
    @Autowired
    private GiteeProvider giteeProvider;
    @Autowired
    private UserMapper userMapper;
    @Value("${gitee.client.id}")
    private String clientId;
    @Value("${gitee.client.secret}")
    private String clientSecret;
    @Value("${gitee.redirect.uri}")
    private String redirectUri;
    @Value("${gitee.grant.type}")
    private String grantType;
    @Override
    public void giteeCallback(String code, HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setGrant_type(grantType);

        String accessToken = giteeProvider.getAccessToken(accessTokenDTO);
        UserDTO giteeUser = giteeProvider.getUser(accessToken);
//        System.out.println(user.getName());
        if (giteeUser != null){
            // 登录成功 写cookie和session
            User user = new User();
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andAccountIdEqualTo(Long.valueOf(giteeUser.getAccountId()));
            List<User> usersByAccountId = userMapper.selectByExample(userExample);
            if (usersByAccountId.size() != 0) {
                user = usersByAccountId.get(0);
            }else {
                user.setAccountId(giteeUser.getId());
                user.setName(giteeUser.getName());
                user.setToken(UUID.randomUUID().toString());
                user.setAvatarUrl(giteeUser.getAvatarUrl());
                user.setGmtCreate(System.currentTimeMillis());
                user.setGmtModified(System.currentTimeMillis());
                userMapper.insert(user);
            }
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            response.addCookie(new Cookie("token", user.getToken()));

        }
    }
}
