package codingforlove.community.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private Integer accountId;
    private String name;
    private String bio;
    private String avatarUrl;
}
