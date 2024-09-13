package codingforlove.community.Service.impl;

import codingforlove.community.Mapper.QuestionMapper;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.Question;
import codingforlove.community.Model.User;
import codingforlove.community.Service.PublishService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Service
public class PublishServiceImpl implements PublishService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public String doPublish(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("tag") String tag,
                            @RequestParam("id") Integer id,
                            Model model,
                            HttpServletRequest request) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        // TODO 前端校验
        if (title == null || title.equals("")){
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description == null || description.equals("")){
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if (tag == null || tag.equals("")){
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setCreatorAccountId(user.getAccountId());
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setId(id);
        if (question.getId() == null){
            question.setGmtCreate(LocalDateTime.now());
            question.setGmtModified(LocalDateTime.now());
            questionMapper.create(question);
        }else {
            question.setGmtModified(LocalDateTime.now());
            questionMapper.update(question);
        }

        return "redirect:/";
    }

    @Override
    public String edit(Integer id, Model model) {
        Question question = questionMapper.findById(id);
        model.addAttribute("title", question.getTitle());
        model.addAttribute("description", question.getDescription());
        model.addAttribute("tag", question.getTag());
        model.addAttribute("id", question.getId());

        return "publish";
    }
}
