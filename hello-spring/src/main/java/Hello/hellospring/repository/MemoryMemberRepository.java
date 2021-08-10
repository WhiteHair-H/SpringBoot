package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>(); // 변수 설정
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // member id값 세팅
        store.put(member.getId(), member); // store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // id값이 null이어도 optional을 통해서 NUll을 처리
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream() // 루프로 돌림
                .filter(member -> member.getName().equals(name))  // 넘어온 이름 값이 같은 경우에만 필터링
                .findAny(); // 반환함수
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // 리스트로 변환
    }

    // Clear 이벤트
    public void clearStore(){
        store.clear();
    }

}
