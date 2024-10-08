package codingforlove.community.Service;

import codingforlove.community.DTO.UserDTO;
import jakarta.servlet.http.HttpServletResponse;

public interface LoginService {
    void login(UserDTO userDTO, HttpServletResponse response);
}
