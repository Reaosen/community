package codingforlove.community.Controller;

import codingforlove.community.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(value = "id") Integer id,
                           Model model){
        return questionService.getById(id, model);
    }

    @DeleteMapping("/question/{id}/delete")
    public String delete(@PathVariable(value = "id") Integer id){
        return questionService.deleteById(id);
    }
}
