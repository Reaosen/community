package codingforlove.community.Controller;

import codingforlove.community.DTO.CommentDTO;
import codingforlove.community.Mapper.CommentMapper;
import codingforlove.community.Model.Comment;
import codingforlove.community.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class commentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO){
        commentService.insert(commentDTO);
        return null;
    }
}
