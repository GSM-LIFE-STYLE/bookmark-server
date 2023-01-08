package lifestyle.bookmark.domain.rank.domain;

import lifestyle.bookmark.domain.member.domain.Member;
import lifestyle.bookmark.global.enum_type.rank_category.RankCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rank_id", nullable = false)
    private Long rankId;

    @OneToMany(mappedBy = "memberId")
    @JoinColumn
    private List<Member> members;

    @Column(name = "rank_category")
    @Enumerated(EnumType.STRING)
    private RankCategory rankCategory;
}
