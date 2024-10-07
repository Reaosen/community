package codingforlove.community.Service.impl;

import cn.hutool.core.util.RandomUtil;
import codingforlove.community.DTO.EmailDTO;
import codingforlove.community.Mapper.EmailCodeMapper;
import codingforlove.community.Model.EmailCode;
import codingforlove.community.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private EmailCodeMapper emailCodeMapper;

    @Override
    public String insert(EmailDTO emailDTO) {
        String emailCode = RandomUtil.randomNumbers(6);
        EmailCode code = new EmailCode();
        code.setEmail(emailDTO.getEmail());
        code.setCode(emailCode);
        emailCodeMapper.insert(code);
        return emailCode;
    }
}
