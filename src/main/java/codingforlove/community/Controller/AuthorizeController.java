package codingforlove.community.Controller;

import codingforlove.community.Service.AuthorizeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
//    @Autowired
//    private GithubProvider githubProvider;
    @Autowired
    private AuthorizeService authorizeService;
    @GetMapping("/giteeCallback")
    public String giteeCallback(@RequestParam(name = "code") String code,
                                HttpServletResponse response) {
       return authorizeService.giteeCallback(code, response);
    }
}
