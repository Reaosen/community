package codingforlove.community.Controller;

import codingforlove.community.DTO.ResultDTO;
import codingforlove.community.DTO.UserDTO;
import codingforlove.community.Service.LoginService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object Login(@RequestBody UserDTO userDTO, HttpServletResponse response){
        loginService.login(userDTO, response);
        return ResultDTO.okOf();
    }
}
