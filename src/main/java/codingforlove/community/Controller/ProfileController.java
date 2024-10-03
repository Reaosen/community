package codingforlove.community.Controller;

import codingforlove.community.DTO.PaginationDTO;
import codingforlove.community.Model.User;
import codingforlove.community.Service.NotificationService;
import codingforlove.community.Service.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private NotificationService notificationService;


    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          Model model,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5") Integer size) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            //todo 未登录提醒
            return "redirect:/";
        }
        //request.getSession().setAttribute("user", user);
        if (action.equals("questions")) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
            PaginationDTO paginationDTO = profileService.list(user, page, size);
            model.addAttribute("pagination", paginationDTO);
        }
        if (action.equals("replies")) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新消息");
            PaginationDTO paginationDTO = notificationService.list(user.getAccountId(), page, size);
            model.addAttribute("pagination", paginationDTO);
        }
        if (action.equals("stars")) {
            model.addAttribute("section", "stars");
            model.addAttribute("sectionName", "我的收藏");
        }
        if (action.equals("concerns")) {
            model.addAttribute("section", "concerns");
            model.addAttribute("sectionName", "我的关注");
        }

        return "profile";
    }
}
