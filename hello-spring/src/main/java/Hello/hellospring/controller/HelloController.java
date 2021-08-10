package Hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // html 이름 지정
    public String hello(Model model)
    {
        // 값 전달
        model.addAttribute("data", "스프링!!!!");
        return "hello";
    }

    // MVC와 템플릿 엔진
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name , Model model){
        model.addAttribute("name",name);
        return "hello-template";
        // http://localhost:8080/hello-mvc?name=spring!!!!!!!
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name)
    {
        return "hello" + name ; // "hello spring"
    }
    // http://localhost:8080/hello-string?name=string

    
    // API - json 방식 - 객체를 반환할 때 주로 사용
    @GetMapping("hello-api")
    @ResponseBody // 객체는 Json 파일로 변환
    public Hello helloApi(@RequestParam("name") String name){
        Hello  hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;
        
    // 프로퍼티 방식
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    }
}
