package codingforlove.community.Controller;

import codingforlove.community.DTO.CommentDTO;
import codingforlove.community.DTO.QuestionDTO;
import codingforlove.community.DTO.ResultDTO;
import codingforlove.community.DTO.UserDTO;
import codingforlove.community.Enum.CommentTypeEnum;
import codingforlove.community.Model.User;
import codingforlove.community.Service.CommentService;
import codingforlove.community.Service.QuestionService;
import codingforlove.community.Service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(value = "id") Long id, Model model, HttpServletRequest request){
        QuestionDTO questionDTO = questionService.getById(id);
        List<CommentDTO> comments = commentService.listByIdAndType(id, CommentTypeEnum.QUESTION);
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        Cookie[] cookies = request.getCookies();
        String token = null;
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                token = cookie.getValue();
            }
        }
        UserDTO userDTO = userService.selectByToken(token);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedQuestions", relatedQuestions);
        model.addAttribute("user", userDTO);
        return "question";
    }

    @DeleteMapping("/question/{id}/delete")
    @ResponseBody
    public Object delete(@PathVariable(value = "id") Long id){
        questionService.deleteById(id);
        return ResultDTO.okOf();
    }
}
