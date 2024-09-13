package codingforlove.community.Model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class User {
    private int id;
    private Integer accountId;
    private String name;
    private String bio;
    private String token;
    private String avatarUrl;
    private LocalDateTime gmtModified;
    private LocalDateTime gmtCreate;
}
