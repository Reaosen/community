package codingforlove.community.Service;

import codingforlove.community.DTO.CommentCreateDTO;
import codingforlove.community.DTO.CommentDTO;
import codingforlove.community.Enum.CommentTypeEnum;
import codingforlove.community.Model.Comment;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CommentService {
    Comment getComment(CommentCreateDTO commentDTO, HttpServletRequest request);

    void insert(Comment comment);

    List<CommentDTO> listByIdAndType(Long id, CommentTypeEnum type);
}
