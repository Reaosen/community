package codingforlove.community.Util;

import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {
    private static CookieUtil cookieUtil;
    @Autowired
    private UserMapper userMapper;

    @PostConstruct
    public void init() {
        cookieUtil = this;
        cookieUtil.userMapper = this.userMapper;
    }

    public static User findUserByToken(HttpServletRequest request) {
        User user = null;
        Cookie[] cookies = request.getCookies();
        if ((cookies != null && cookies.length != 0)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = cookieUtil.userMapper.findByToken(token);
                    if (user != null) {
                        break;
                    }
                }
            }
        }
        return user;
    }
}
