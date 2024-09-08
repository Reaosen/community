package codingforlove.community.DTO;

import lombok.Data;

@Data
public class TokenResponseDTO {
    private String access_token;
    private String token_type;
    private int expires_in;
    private String refresh_token;
    private String scope;
    private long created_at;
}
