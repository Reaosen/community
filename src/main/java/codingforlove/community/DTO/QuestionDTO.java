package codingforlove.community.DTO;

import codingforlove.community.Model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private Long creatorAccountId;
    private Integer likeCount;
    private Integer commentCount;
    private Integer viewCount;
    private String tag;
    private User user;
    private Long gmtModified;
    private Long gmtCreate;
}
