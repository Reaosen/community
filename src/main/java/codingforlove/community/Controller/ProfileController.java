package codingforlove.community.Controller;

import codingforlove.community.DTO.PaginationDTO;
import codingforlove.community.Model.User;
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
        request.getSession().setAttribute("user", user);
        if (action.equals("questions")) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        }
        if (action.equals("replies")) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新消息");
        }
        if (action.equals("stars")) {
            model.addAttribute("section", "stars");
            model.addAttribute("sectionName", "我的收藏");
        }
        if (action.equals("concerns")) {
            model.addAttribute("section", "concerns");
            model.addAttribute("sectionName", "我的关注");
        }
        PaginationDTO paginationDTO = profileService.profile(user, action, page, size);
        model.addAttribute("pagination", paginationDTO);
        return "profile";
    }
}
