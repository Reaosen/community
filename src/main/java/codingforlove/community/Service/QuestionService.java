package codingforlove.community.Service;

import codingforlove.community.DTO.PaginationDTO;
import org.springframework.ui.Model;

public interface QuestionService {
    PaginationDTO list(Model model, Integer page, Integer size);

    PaginationDTO list(Long id, Integer page, Integer size);

    String getById(Long id, Model model);

    void incView(Long id);

    String deleteById(Long id);
}
