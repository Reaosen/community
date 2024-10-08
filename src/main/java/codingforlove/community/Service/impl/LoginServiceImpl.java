package codingforlove.community.Service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import codingforlove.community.DTO.UserDTO;
import codingforlove.community.Exception.CustomizeErrorCode;
import codingforlove.community.Exception.CustomizeException;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.User;
import codingforlove.community.Model.UserExample;
import codingforlove.community.Service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void login(UserDTO userDTO, HttpServletResponse response) {
        if (StrUtil.isBlank(userDTO.getEmail()) || StrUtil.isBlank(userDTO.getPassword())) {
            throw new CustomizeException(CustomizeErrorCode.IS_EMPTY);
        }
        UserExample example = new UserExample();
        example.createCriteria()
                .andEmailEqualTo(userDTO.getEmail())
                .andPasswordEqualTo(userDTO.getPassword());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 0) {
            throw new CustomizeException(CustomizeErrorCode.PASSWORD_OR_EMAIL_WRONG);
        }
        // 登录成功 写cookie和session
        User user = users.get(0);
        user.setToken(UUID.randomUUID().toString());
        user.setName(RandomUtil.randomString(6));
        user.setAvatarUrl("/images/defaultIcon.jpg");
        user.setBio("该用户很懒，什么都没有写.");
        userMapper.updateByPrimaryKey(user);
        response.addCookie(new Cookie("token", user.getToken()));
    }
}
