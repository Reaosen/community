package codingforlove.community.Controller;

import codingforlove.community.Service.IndexService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @GetMapping("/")
    public String index(HttpServletRequest request){
        return indexService.login(request);

    }
}
