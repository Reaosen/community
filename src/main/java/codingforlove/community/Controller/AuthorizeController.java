package codingforlove.community.Controller;

import codingforlove.community.DTO.AccessTokenDTO;
import codingforlove.community.DTO.UserDTO;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.User;
import codingforlove.community.Provider.GiteeProvider;
import codingforlove.community.Service.AuthorizeService;
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
    private AuthorizeService authorizeService;
    @GetMapping("/giteeCallback")
    public String giteeCallback(@RequestParam(name = "code") String code,
                                HttpServletRequest request) {
       return authorizeService.giteeCallback(code, request);
    }
}
