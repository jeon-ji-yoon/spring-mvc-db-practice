package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //Given 테스트 코드 작성 시 자주 쓰이는 원칙이다_ 주어진 조건을 의미한다
        Member member = new Member();
        member.setName("hello");

        //When 테스트 하려는 상황을 코드로 나타낸다
        Long saveId = memberService.join(member); //제대로 id가 부여되엇다 확인하는 작업이 필요할 것같다(join하는 것은 repo에 save하는 것이이라서)

        //Then 테스트 하려는 상황을 테스트 하는 코드이다
        Member findMember = memberRepository.findById(saveId).get();//optional에서 객체값만 빼낼 것
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        //Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //    assertThrow ==   왼쪽에 있는 예외가 발생해야 한다, ()->가 실행되는 경우

    }


}