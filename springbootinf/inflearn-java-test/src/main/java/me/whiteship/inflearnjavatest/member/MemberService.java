package me.whiteship.inflearnjavatest.member;

import me.whiteship.inflearnjavatest.domain.Member;

import java.util.Optional;

public interface MemberService {

	Optional<Member> findById(Long memberId);

}
