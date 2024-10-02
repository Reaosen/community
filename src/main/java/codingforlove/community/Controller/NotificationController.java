package codingforlove.community.Controller;

import codingforlove.community.DTO.NotificationDTO;
import codingforlove.community.Model.User;
import codingforlove.community.Service.NotificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String read(HttpServletRequest request,
                       @PathVariable(name = "id") Long id) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/";
        }
        Long outerId = notificationService.read(id, user);
        return "redirect:/question/" + outerId;
    }
}
