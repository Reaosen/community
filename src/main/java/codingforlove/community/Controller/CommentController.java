package codingforlove.community.Controller;

import cn.hutool.core.util.StrUtil;
import codingforlove.community.DTO.CommentCreateDTO;
import codingforlove.community.DTO.CommentDTO;
import codingforlove.community.DTO.ResultDTO;
import codingforlove.community.Enum.CommentTypeEnum;
import codingforlove.community.Exception.CustomizeErrorCode;
import codingforlove.community.Model.Comment;
import codingforlove.community.Model.User;
import codingforlove.community.Service.CommentService;
import codingforlove.community.Service.NotificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;


    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if (commentCreateDTO == null || StrUtil.isBlank(commentCreateDTO.getContent())){
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = commentService.getComment(commentCreateDTO, request);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List> comments(@PathVariable(value = "id") Long id){
        List<CommentDTO> commentDTOS = commentService.listByIdAndType(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
}
