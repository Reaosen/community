package codingforlove.community.Service.impl;

import codingforlove.community.DTO.AccessTokenDTO;
import codingforlove.community.DTO.UserDTO;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.User;
import codingforlove.community.Provider.GiteeProvider;
import codingforlove.community.Service.AuthorizeService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public String giteeCallback(String code, HttpServletResponse response) {
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
            user.setAccountId(String.valueOf(giteeUser.getId()));
            user.setName(giteeUser.getName());
            user.setToken(UUID.randomUUID().toString());
            user.setAvatarUrl(giteeUser.getAvatarUrl());
            user.setGmtCreate(LocalDateTime.now());
            user.setGmtModified(LocalDateTime.now());

            userMapper.insert(user);
            response.addCookie(new Cookie("token", user.getToken()));
            return "redirect:/";
        }else {
            //登录失败 重新登录
            return "redirect:/";
        }
    }
}
