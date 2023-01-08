package lifestyle.bookmark.global.util;

import lifestyle.bookmark.domain.member.domain.RankMember;
import lifestyle.bookmark.domain.member.domain.repository.MemberRepository;
import lifestyle.bookmark.domain.member.facade.MemberFacade;
import lifestyle.bookmark.domain.rank.presentation.dto.response.RankMemberBookResponse;
import lifestyle.bookmark.domain.rank.presentation.dto.response.RankMemberPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemberUtil {
    private final MemberRepository memberRepository;

    public List<RankMemberPageResponse> rankPageMemberToDtoList(List<RankMember> members) {
        List<RankMemberPageResponse> response = members.stream().map(m -> new RankMemberPageResponse
                        (m.getMember().getLoginId(), m.getMember().getName(), m.getMember().getReadPage()))
                .collect(Collectors.toList());
        return response;
    }

    public List<RankMemberBookResponse> rankBookMemberToDtoList(List<RankMember> members) {
        List<RankMemberBookResponse> response = members.stream().map(m -> new RankMemberBookResponse
                        (m.getMember().getLoginId(), m.getMember().getName(), m.getMember().getReadPage()))
                .collect(Collectors.toList());
        return response;
    }
}
