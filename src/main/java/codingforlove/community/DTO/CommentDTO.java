package codingforlove.community.DTO;

import codingforlove.community.Model.User;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private String content;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Long commentCount;
    private User user;
}
