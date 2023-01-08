package lifestyle.bookmark.domain.rank.service;

import lifestyle.bookmark.domain.rank.presentation.dto.response.RankMemberBookResponse;
import lifestyle.bookmark.domain.rank.presentation.dto.response.RankMemberPageResponse;

import java.util.List;

public interface RankService {

    void createPageRank();
    void createBookRank();
    List<RankMemberPageResponse> getPageRank();
    List<RankMemberBookResponse> getBookRank();
}
