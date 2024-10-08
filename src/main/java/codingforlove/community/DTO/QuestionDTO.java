package codingforlove.community.DTO;

import codingforlove.community.Model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String profile;
    private Long creatorAccountId;
    private Long likeCount;
    private Long commentCount;
    private Long viewCount;
    private String tag;
    private User user;
    private Long gmtModified;
    private Long gmtCreate;
}
