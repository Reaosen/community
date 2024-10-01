package codingforlove.community.Service;

import jakarta.servlet.http.HttpServletResponse;

public interface AuthorizeService {

    void giteeCallback(String code, HttpServletResponse response);
}
