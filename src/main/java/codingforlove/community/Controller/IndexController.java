package codingforlove.community.Controller;

import codingforlove.community.Cache.HotTagCache;
import codingforlove.community.DTO.PaginationDTO;
import codingforlove.community.Service.IndexService;
import codingforlove.community.Service.QuestionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private HotTagCache hotTagCache;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {

        PaginationDTO paginationDTO = indexService.login(request, page, size);
        List<String> tags = hotTagCache.getHosts();
        model.addAttribute("pagination", paginationDTO);
        model.addAttribute("tags", tags);
        return "index";

    }
}
