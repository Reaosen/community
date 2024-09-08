package codingforlove.community.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Question {
    private String title;
    private String description;
    private Integer creatorId;
    private Integer likeCount;
    private Integer commentCount;
    private Integer viewCount;
    private String tag;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
