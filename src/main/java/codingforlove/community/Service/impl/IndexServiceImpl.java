package codingforlove.community.Service.impl;

import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.User;
import codingforlove.community.Service.IndexService;
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
        // TODO mysql数据库压力过大，可以换成redis
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null){
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }

        return "index";
    }
}
