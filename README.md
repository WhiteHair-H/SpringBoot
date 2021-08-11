# SpringBoot
Java SpringBoot 리포지토리


### 시작 날짜 : 8/10
- SpringBoot 시작

### 환경 설정
1. Java 11
2. intellij

### 프로젝트 만들기
- https://start.spring.io/
- Spring Web 라이브러리
- Thymeleaf - HTML 사용하기 위한 라이브러리
- 라이브러리는 서로 의존 관계
- Intellij - Github 연동

### Intellij 실행
- https://goddaehee.tistory.com/249
- 한글설정하기 : plugin 클릭후 Korean 언어팩 
- 빌드 변경 : 설정 - gradle - 빌드 및 실행 - Intellij IDEA 변경
- 오류 : Execution failed for task ':compileJava'. - JDK 버전 

### 스프링 웹 개발 기초
- 정적컨텐츠 : 파일 그대로 웹 브라우저 전달
- MVC와 템플릿 엔진 : 서버에서 변형한뒤 HTML 전달
- API : 데이터만 입력했을 때 화면에 전달

### 회원관리 예제 - 백엔드 개발
- 비즈니스 요구사항 정리
- 데이터: 회원 ID , 이름
- 기능: 회원 등록 , 조회

### 코드작성후 검증 작업
- 테스트 케이스 


### 순서
- 구현 -> 테스트 작성 
- 테스트 작성 -> 구현 : 미리 틀을 만들어놓고 실행하면서 현재 상황을 파악하는 방법(TDD)



### 단축키
- ALT + INS - getter, setter 출력
- shift + F6 - 이름 한번에 바꾸기
- ctrl + alt + m - Extract Method = 함수 빠르게 생성
- shift + F10 - 이전 테스트 실행(유용하게 사용됨)


### 용어정리
#### Dependency Injection(DI) 장점
- 재사용성을 높임.
- 테스트에 용이.
- 코드도 단순화.

#### 의존성 주입(사진 추가)
- 참조설명(https://medium.com/@jang.wangsu/di-dependency-injection-%EC%9D%B4%EB%9E%80-1b12fdefec4f)
- 의존성 : B 클래스에서 A 클래스를 내부에 변수로 사용하게 됨으로써 B 클래스는 A 클래스에 의존관계가 생기게 됨.
- 주입 : B 클래스 함수를 외부에서 객체를 생성해서 넣어주는 것.
- 의존성 주입 : 내부에서 만든 변수를 외부에서 넣어주는 것
- 종류 : 필드 주입, setter 주입, 생성자 주입 ===> 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 **생성자 주입**을 권장


### 스프링 빈과 의존관계

#### 컴포넌트 스캔과 자동 의존관계 설정
- @Component애노테이션이 있으면 자동으로 스프링 빈으로 자동 등록된다
- @Controller , @Service , @Repository
- 기본으로 싱글톤으로 등록됨
- *정형화된 컨트롤러, 서비스 , 리포지토리 같은 코드떄 사용*


#### 싱글톤
- 유일하게 하나만 등록해서 공유


```
// 회원 서비스 스프링 빈 등록
@Service
  public class MemberService {
  
  private final MemberRepository memberRepository;
  
  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
}


```

#### 자바 코드로 직접 스프링 빈 등록하기
- 회원 서비스와 회원 리포지토리의 @Service, @Repository, @Autowired 애노테이션을 제거하고 진행
- 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록
```
@Configuration
public class SpringConfig {

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }
  
  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
}
```


### DB
- [H2 DB](https://www.h2database.com)




