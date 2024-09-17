package codingforlove.community.Service;

import codingforlove.community.DTO.PaginationDTO;
import codingforlove.community.DTO.QuestionDTO;
import org.springframework.ui.Model;

public interface QuestionService {
    PaginationDTO list(Model model, Integer page, Integer size);

    PaginationDTO list(int id, Integer page, Integer size);

    String getById(Integer id, Model model);

    void incView(Integer id);

    String deleteById(Integer id);
}
