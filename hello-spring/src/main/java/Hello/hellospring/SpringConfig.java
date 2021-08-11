package Hello.hellospring;

import Hello.hellospring.repository.JdbcMemberRepository;
import Hello.hellospring.repository.MemberRepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import Hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


// 자바코드로 직접 실행시켜 스프링 빈 등록
@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()  {
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource); // 데이터베이스
    }

}
