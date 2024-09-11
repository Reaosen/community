package codingforlove.community.Service;

import codingforlove.community.DTO.PaginationDTO;
import org.springframework.ui.Model;

public interface QuestionService {
    PaginationDTO list(Model model, Integer page, Integer size);

    PaginationDTO list(int id, Integer page, Integer size);
}
