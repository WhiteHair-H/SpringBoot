package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Null을 처리하는 방법
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
