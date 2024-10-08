package codingforlove.community.Service.impl;

import cn.hutool.core.util.RandomUtil;
import codingforlove.community.DTO.UndefinedUserDTO;
import codingforlove.community.Exception.CustomizeErrorCode;
import codingforlove.community.Exception.CustomizeException;
import codingforlove.community.Mapper.EmailCodeMapper;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.EmailCode;
import codingforlove.community.Model.EmailCodeExample;
import codingforlove.community.Model.User;
import codingforlove.community.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private EmailCodeMapper emailCodeMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public String insertEmailCode(UndefinedUserDTO emailDTO) {
        String emailCode = RandomUtil.randomNumbers(6);
        EmailCode code = new EmailCode();
        code.setEmail(emailDTO.getEmail());
        code.setCode(emailCode);
        emailCodeMapper.insert(code);
        return emailCode;
    }

    @Override
    public void codeCompare(UndefinedUserDTO signUpDTO) {

        EmailCodeExample codeExample = new EmailCodeExample();
        codeExample.createCriteria()
                .andCodeEqualTo(signUpDTO.getCode())
                .andEmailEqualTo(signUpDTO.getEmail());
        List<EmailCode> emailCodes = emailCodeMapper.selectByExample(codeExample);
        if (emailCodes.size() == 0){
            throw new CustomizeException(CustomizeErrorCode.EMAIL_CODE_WRONG);
        }
    }

    @Override
    public void insert(UndefinedUserDTO signUpDTO) {
        User user = new User();
        user.setAccountId(Long.valueOf(RandomUtil.randomNumbers(9)));
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(signUpDTO.getPassword());
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(System.currentTimeMillis());
        userMapper.insert(user);
    }
}
