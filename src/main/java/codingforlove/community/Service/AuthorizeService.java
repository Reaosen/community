package codingforlove.community.Service;

import jakarta.servlet.http.HttpServletRequest;

public interface AuthorizeService {

    String giteeCallback(String code, HttpServletRequest request);
}
