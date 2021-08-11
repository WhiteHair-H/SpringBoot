package Hello.hellospring.controller;

import Hello.hellospring.domain.Member;
import Hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    // 생성자
    private final MemberService memberService;

    // 명시적으로 알려주기위한 연결작업 생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    // 회원등록
    //get 방식 url입력 때 사용
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm"; // html 찾아감
    }

    // post 방식 - 데이터를 넣고 부를 때 사용
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName()); // set에 등록된 것을 get으로 가지고옴

        memberService.join(member);

        return "redirect:/";
    }

    // 회원조회
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
