package codingforlove.community.Service;

import codingforlove.community.DTO.UserDTO;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthorizeService {

    UserDTO giteeCallback(String code, HttpServletResponse response);
}
