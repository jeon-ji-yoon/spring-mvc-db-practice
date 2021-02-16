package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean //내가 스프링 빈을 등록할거야
    public MemberService memberService() {
        return new MemberService( memberRepository() );
    }
    //마치 Autowire처럼 스프링 빈에 등록된 객체를 파라미터로 넘겨준다
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
