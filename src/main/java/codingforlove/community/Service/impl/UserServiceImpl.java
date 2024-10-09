package codingforlove.community.Service.impl;

import codingforlove.community.DTO.UserDTO;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.User;
import codingforlove.community.Model.UserExample;
import codingforlove.community.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDTO selectByToken(String token) {
        UserDTO userDTO = new UserDTO();
        if (token == null){
            userDTO.setAccountId(null);
            return userDTO;
        }
        UserExample example = new UserExample();
        example.createCriteria()
                        .andTokenEqualTo(token);
        List<User> users = userMapper.selectByExample(example);
        User user = users.get(0);
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
