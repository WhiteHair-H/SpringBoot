package Hello.hellospring;

import Hello.hellospring.repository.*;
import Hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


// 자바코드로 직접 실행시켜 스프링 빈 등록
@Configuration
public class SpringConfig {

    private final EntityManager em;
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(EntityManager em, DataSource dataSource) {
        this.em = em;
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()  {
        // return new MemoryMemberRepository();
        // new JdbcMemberRepository(dataSource); // 데이터베이스

        // return new JdbcTemplateMemberRepository((dataSource));
        return new JpaMemberRepository(em);
    }

}
