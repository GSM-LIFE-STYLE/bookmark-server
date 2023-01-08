package lifestyle.bookmark.domain.rank.service.impl;

import lifestyle.bookmark.domain.member.domain.Member;
import lifestyle.bookmark.domain.member.domain.RankMember;
import lifestyle.bookmark.domain.member.domain.repository.MemberRepository;
import lifestyle.bookmark.domain.member.domain.repository.RankMemberRepository;
import lifestyle.bookmark.domain.member.exception.MemberNotFoundException;
import lifestyle.bookmark.domain.rank.domain.Rank;
import lifestyle.bookmark.domain.rank.domain.repository.RankRepository;
import lifestyle.bookmark.domain.rank.exception.NotFoundRankException;
import lifestyle.bookmark.domain.rank.service.RankService;
import lifestyle.bookmark.global.enum_type.rank_category.RankCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {

    private final MemberRepository memberRepository;
    private final RankRepository rankRepository;
    private final RankMemberRepository rankMemberRepository;

    private List<Member> getSortMembers() {
        List<Member> members = memberRepository.findAll();
        if(members.isEmpty())
            throw new MemberNotFoundException("멤버가 존재하지 않습니다.");

        return members;
    }

    private void createRankMember(List<Member> members, Rank rank) {
        for (Member member : members) {
            RankMember rankMember = RankMember.builder().member(member).rank(rank).build();
            rankMemberRepository.save(rankMember);
        }
    }

    @Override
    public void createPageRank() {
        List<Member> members = getSortMembers();

        Rank rank = Rank.builder()
                .members(members)
                .rankCategory(RankCategory.PAGE)
                .build();

        createRankMember(members , rank);
    }

    @Override
    public void createBookRank() {
        List<Member> members = getSortMembers();

        Rank rank = Rank.builder()
                .members(members)
                .rankCategory(RankCategory.BOOK)
                .build();

        createRankMember(members , rank);
    }
}
