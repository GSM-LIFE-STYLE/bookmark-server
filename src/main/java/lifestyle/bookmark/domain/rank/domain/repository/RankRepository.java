package lifestyle.bookmark.domain.rank.domain.repository;

import lifestyle.bookmark.domain.rank.domain.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank, Long> {
}
