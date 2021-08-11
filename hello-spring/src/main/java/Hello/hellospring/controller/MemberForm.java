package Hello.hellospring.controller;

import Hello.hellospring.domain.Member;
import org.springframework.web.bind.annotation.PostMapping;

public class MemberForm {
    // input - name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
