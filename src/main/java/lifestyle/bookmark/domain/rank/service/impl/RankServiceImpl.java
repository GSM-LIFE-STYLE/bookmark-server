package lifestyle.bookmark.domain.rank.service.impl;

import lifestyle.bookmark.domain.member.domain.Member;
import lifestyle.bookmark.domain.member.domain.RankMember;
import lifestyle.bookmark.domain.member.domain.repository.MemberRepository;
import lifestyle.bookmark.domain.member.domain.repository.RankMemberRepository;
import lifestyle.bookmark.domain.member.exception.MemberNotFoundException;
import lifestyle.bookmark.domain.rank.domain.Rank;
import lifestyle.bookmark.domain.rank.domain.repository.RankRepository;
import lifestyle.bookmark.domain.rank.presentation.dto.response.RankMemberBookResponse;
import lifestyle.bookmark.domain.rank.presentation.dto.response.RankMemberPageResponse;
import lifestyle.bookmark.domain.rank.service.RankService;
import lifestyle.bookmark.global.enum_type.rank_category.RankCategory;
import lifestyle.bookmark.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {

    private final MemberRepository memberRepository;
    private final RankRepository rankRepository;
    private final RankMemberRepository rankMemberRepository;
    private final MemberUtil memberUtil;

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
    @Transactional
    public void createPageRank() {
        List<Member> members = getSortMembers();

        Rank rank = Rank.builder()
                .members(members)
                .rankCategory(RankCategory.PAGE)
                .build();

        rankRepository.save(rank);
        createRankMember(members , rank);
    }

    @Override
    @Transactional
    public void createBookRank() {
        List<Member> members = getSortMembers();

        Rank rank = Rank.builder()
                .members(members)
                .rankCategory(RankCategory.BOOK)
                .build();

        rankRepository.save(rank);
        createRankMember(members , rank);
    }

    @Override
    public List<RankMemberPageResponse> getPageRank() {

        List<RankMember> sortRankMember = rankMemberRepository
                .findAll(Sort.by(Sort.Direction.DESC, "readPage"));

        if(sortRankMember.isEmpty())
            throw new MemberNotFoundException("멤버가 존재하지 않습니다.");

        List<RankMemberPageResponse> response = memberUtil.rankPageMemberToDtoList(sortRankMember);

        return response;
    }

    @Override
    public List<RankMemberBookResponse> getBookRank() {
        List<RankMember> sortRankMember = rankMemberRepository
                .findAll(Sort.by(Sort.Direction.DESC, "readBookCount"));

        if(sortRankMember.isEmpty())
            throw new MemberNotFoundException("멤버가 존재하지 않습니다.");

        List<RankMemberBookResponse> response = memberUtil.rankBookMemberToDtoList(sortRankMember);

        return response;
    }
}
