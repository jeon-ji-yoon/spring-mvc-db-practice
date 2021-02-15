package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);  //방금 그 id로 회원을 찾는 메소드
    // null을 처리하는 방법
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
