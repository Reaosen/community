package codingforlove.community.Service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProfileService {
    String profile(HttpServletRequest request,
                   String action,
                   Model model,
                   @RequestParam(name = "page", defaultValue = "1") Integer page,
                   @RequestParam(name = "size", defaultValue = "5") Integer size);
}
