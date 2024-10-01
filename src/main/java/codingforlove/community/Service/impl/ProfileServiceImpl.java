package codingforlove.community.Service.impl;

import codingforlove.community.DTO.PaginationDTO;
import codingforlove.community.Model.User;
import codingforlove.community.Service.ProfileService;
import codingforlove.community.Service.QuestionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private QuestionService questionService;

    @Override
    public PaginationDTO profile(User user,
                                 String action,
                                 @RequestParam(name = "page", defaultValue = "1") Integer page,
                                 @RequestParam(name = "size", defaultValue = "5") Integer size) {

        PaginationDTO paginationDTO = questionService.list(user.getAccountId(), page, size);

        return paginationDTO;
    }
}
