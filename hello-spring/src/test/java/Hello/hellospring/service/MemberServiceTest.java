package Hello.hellospring.service;

import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    // MemoryMemberRepository는 서로 다른 인스턴스 (Test <-> 구현)
    MemoryMemberRepository memberRepository;

    // 실행전에 호출
    @BeforeEach
    public void beforeEach()
    {
        // 의존성 주입(DI)
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    // 실행후에 호출
    // Clear 이벤트
    // 테스트에는 순서가 없기때문에 테스트가 끝날때 Clear 이벤트 사용
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void 회원가입() {
        // 문법
        //given 상황이 주어지고
        Member member = new Member();
        member.setName("hello");

        //when 어디서 이루어지고
        Long saveId = memberService.join(member);

        //then 결과가 나온다
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1); // member1조인
        // TryCatch보다 좋은 람다방식 () ->
        // member2를 사용했을 때 예외가 발생해야함
        IllegalStateException e = assertThrows(IllegalStateException.class, () ->memberService.join(member2));
        //
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e)
//        {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }


        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}