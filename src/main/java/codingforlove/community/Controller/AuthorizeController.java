package codingforlove.community.Controller;

import codingforlove.community.DTO.AccessTokenDTO;
import codingforlove.community.DTO.UserDTO;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.User;
import codingforlove.community.Provider.GiteeProvider;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public class AuthorizeController {
//    @Autowired
//    private GithubProvider githubProvider;
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

    @GetMapping("/giteeCallback")
    public String giteeCallback(@RequestParam(name = "code") String code,
                                HttpServletRequest request) {
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
            user.setGmtCreate(LocalDateTime.now());
            user.setGmtModified(LocalDateTime.now());

            userMapper.insert(user);
            request.getSession().setAttribute("user", giteeUser);
            return "redirect:/";
        }else {
            //登录失败 重新登录
            return "redirect:/";
        }
    }

    /*
 TODO 未完成的github授权登录

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code) throws IOException {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("Iv23liwYXBUUgR4l37Bo");
        accessTokenDTO.setClient_secret("cf3a33c9a8b28c91a6a82f04c508583434931c3b");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        UserDTO user = githubProvider.getGithubUser(accessToken);
        System.out.println(user.getName());

        return "index";
    }
*/


}
