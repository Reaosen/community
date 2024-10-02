package codingforlove.community.Service;

import codingforlove.community.DTO.PaginationDTO;
import codingforlove.community.Model.User;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProfileService {
    PaginationDTO list(User user,
                       @RequestParam(name = "page", defaultValue = "1") Integer page,
                       @RequestParam(name = "size", defaultValue = "5") Integer size);
}
