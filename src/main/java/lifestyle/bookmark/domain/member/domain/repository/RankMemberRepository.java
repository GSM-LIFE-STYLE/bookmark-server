package lifestyle.bookmark.domain.member.domain.repository;

import lifestyle.bookmark.domain.member.domain.RankMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankMemberRepository extends JpaRepository<RankMember, Long> {
}
