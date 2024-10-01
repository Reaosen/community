package codingforlove.community.Service;

import codingforlove.community.Model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface PublishService {
    public void doPublish(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("tag") String tag,
                          @RequestParam(value = "id", required = false) Long id,
                          User user);

    String edit(Long id, Model model);
}
