package Hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // mapping 먼저 찾고 컨트롤 호출
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
