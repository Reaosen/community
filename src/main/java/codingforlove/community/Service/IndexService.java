package codingforlove.community.Service;

import codingforlove.community.DTO.PaginationDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public interface IndexService {
    PaginationDTO login(HttpServletRequest request, Integer page, Integer size);
}
