package lifestyle.bookmark.domain.member.domain.repository;

import lifestyle.bookmark.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
