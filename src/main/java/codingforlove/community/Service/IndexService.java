package codingforlove.community.Service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public interface IndexService {
    String login(HttpServletRequest request, Model model, Integer page, Integer size);
}
