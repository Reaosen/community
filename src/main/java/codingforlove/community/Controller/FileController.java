package codingforlove.community.Controller;

import codingforlove.community.DTO.FileResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {
    @RequestMapping("file/upload")
    @ResponseBody
    public FileResultDTO upload(){
        // todo 未完成的文件云存储
        FileResultDTO fileResultDTO = new FileResultDTO();
        fileResultDTO.setSuccess(1);
        fileResultDTO.setMessage("success");
        fileResultDTO.setUrl("/images/wechat.jpg");
        return fileResultDTO;
    }
}
