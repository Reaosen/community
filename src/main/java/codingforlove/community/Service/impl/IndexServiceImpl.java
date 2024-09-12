package codingforlove.community.Service.impl;

import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Service.IndexService;
import codingforlove.community.Service.QuestionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @Override
    public String login(HttpServletRequest request, Model model, Integer page, Integer size) {
        //TODO mysql数据库压力过大，可以换成redis
        model.addAttribute("pagination", questionService.list(model, page, size));
        return "index";
    }
}
