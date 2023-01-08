package lifestyle.bookmark.domain.rank.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RankMemberBookResponse {
    private final String loginId;
    private final String name;
    private final Integer readBookCount;
}
