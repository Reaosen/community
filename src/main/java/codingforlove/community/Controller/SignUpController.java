package codingforlove.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SignUpController {
    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @GetMapping("/signUp/{email}")
    public void sentCode(@PathVariable(name = "email") String email){


    }
}
