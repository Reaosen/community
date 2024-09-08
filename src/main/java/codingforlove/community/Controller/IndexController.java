package codingforlove.community.Controller;

import codingforlove.community.Service.IndexService;
import codingforlove.community.Service.QuestionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        String login = indexService.login(request);
        model.addAttribute("questions", questionService.list(model));
        return login;

    }
}
