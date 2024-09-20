package codingforlove.community.Service;

import codingforlove.community.DTO.CommentDTO;
import codingforlove.community.Model.Comment;
import jakarta.servlet.http.HttpServletRequest;

public interface CommentService {
    Comment getComment(CommentDTO commentDTO, HttpServletRequest request);

    void insert(Comment comment);
}
