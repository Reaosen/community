package codingforlove.community.Service.impl;

import codingforlove.community.Mapper.QuestionMapper;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.Question;
import codingforlove.community.Model.User;
import codingforlove.community.Service.PublishService;
import codingforlove.community.Util.CookieUtil;
import jakarta.servlet.http.Cookie;
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

        User user = CookieUtil.findUserByToken(request);
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setCreatorId(user.getId());
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setGmtCreate(LocalDateTime.now());
        question.setGmtModified(LocalDateTime.now());
        questionMapper.create(question);

        return "redirect:/";
    }
}
