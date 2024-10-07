package codingforlove.community.Controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import codingforlove.community.DTO.SignUpDTO;
import codingforlove.community.DTO.ResultDTO;
import codingforlove.community.Exception.CustomizeErrorCode;
import codingforlove.community.Exception.CustomizeException;
import codingforlove.community.Model.User;
import codingforlove.community.Service.SignUpService;
import codingforlove.community.Util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String signUp(Model model){
        return "signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    @ResponseBody
    public Object sentCode(@RequestBody SignUpDTO emailDTO, Model model){
        if (emailDTO == null || StrUtil.isBlank(emailDTO.getEmail())){
            throw new CustomizeException(CustomizeErrorCode.IS_EMPTY);
        }
        String emailCode = signUpService.insertEmailCode(emailDTO);
        String text = "<!DOCTYPE html>\n" +
                "<html lang=\"zh-CN\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>验证码</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <p>感谢您在 Loki论坛 注册。请通过输入以下验证码来验证您的电子邮件地址：</p>\n" +
                "    <p style=\"font-size: 1.5em; font-weight: bold;\">"+ emailCode +"</p>\n" +
                "    <p>此验证码将在 5 分钟后过期。</p>\n" +
                "    <p>如果您未进行此操作，请忽略此邮件。</p>\n" +
                "    <p>此致，</p>\n" +
                "    <p>Loki论坛 团队</p>\n" +
                "</body>\n" +
                "</html>";
        MailUtils.sendMail(emailDTO, text, "您的Loki验证码为：" + emailCode);
        model.addAttribute("codeStatus", 1);
        return ResultDTO.okOf();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object signUp(@RequestBody SignUpDTO signUpDTO){
        signUpService.codeCompare(signUpDTO);
        signUpService.insert(signUpDTO);
        //TODO 不能跳转
        return "redirect:/login";
    }
}
