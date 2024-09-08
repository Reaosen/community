package codingforlove.community.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String bio;
    private String avatarUrl;
}
