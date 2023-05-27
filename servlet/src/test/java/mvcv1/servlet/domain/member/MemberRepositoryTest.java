package mvcv1.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() throws Exception {
        //given -- 조건
        Member member = new Member("hello", 20);

        //when -- 동작
        Member savedMember = memberRepository.save(member);

        //then -- 검증
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    
    @Test
    public void findAll() throws Exception {
        //given -- 조건
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when -- 동작
        List<Member> result = memberRepository.findAll();

        //then -- 검증
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}