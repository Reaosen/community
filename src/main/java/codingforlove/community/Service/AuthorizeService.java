package codingforlove.community.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthorizeService {

    String giteeCallback(String code, HttpServletResponse response);
}
