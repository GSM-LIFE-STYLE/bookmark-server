package lifestyle.bookmark.domain.rank.presentation.dto.response;

import lombok.*;

@Getter @Builder
@RequiredArgsConstructor
public class RankMemberPageResponse {
    private final String loginId;
    private final String name;
    private final Integer page;
}
