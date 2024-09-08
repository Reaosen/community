package codingforlove.community.Service;

import codingforlove.community.DTO.QuestionDTO;
import org.springframework.ui.Model;
import java.util.List;

public interface QuestionService {
    List<QuestionDTO> list(Model model);
}
