package codingforlove.community.Service.impl;

import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.User;
import codingforlove.community.Service.IndexService;
import codingforlove.community.Util.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(HttpServletRequest request) {
        //TODO mysql数据库压力过大，可以换成redis
        User user = CookieUtil.findUserByToken(request);

        request.getSession().setAttribute("user", user);

        return "index";
    }
}
