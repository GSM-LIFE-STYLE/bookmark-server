package lifestyle.bookmark.domain.member.domain;

import lifestyle.bookmark.domain.rank.domain.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rank_member_id", nullable = false)
    private Long rankMemberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rank_id")
    private Rank rank;
}
