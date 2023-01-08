package lifestyle.bookmark.domain.rank.domain.repository;

import lifestyle.bookmark.domain.rank.domain.Rank;
import lifestyle.bookmark.global.enum_type.rank_category.RankCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RankRepository extends JpaRepository<Rank, Long> {
    Optional<Rank> findByRankCategory(RankCategory rankCategory);
}
