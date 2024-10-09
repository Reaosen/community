package codingforlove.community.Service;

import codingforlove.community.DTO.UserDTO;

public interface UserService {
    UserDTO selectByToken(String token);
}
