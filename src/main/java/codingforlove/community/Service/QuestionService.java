package codingforlove.community.Service;

import codingforlove.community.DTO.PaginationDTO;
import codingforlove.community.DTO.QuestionDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface QuestionService {
    PaginationDTO list(Model model, Integer page, Integer size);

    PaginationDTO list(Long id, Integer page, Integer size);

    QuestionDTO getById(Long id);

    void incView(Long id);

    void deleteById(Long id);

    List<QuestionDTO> selectRelated(QuestionDTO questionDTO);
}
