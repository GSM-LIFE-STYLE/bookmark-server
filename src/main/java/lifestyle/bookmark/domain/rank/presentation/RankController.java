package lifestyle.bookmark.domain.rank.presentation;

import lifestyle.bookmark.domain.rank.presentation.dto.response.RankMemberBookResponse;
import lifestyle.bookmark.domain.rank.presentation.dto.response.RankMemberPageResponse;
import lifestyle.bookmark.domain.rank.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rank")
public class RankController {

    private final RankService rankService;

    @GetMapping("/book")
    public ResponseEntity<List<RankMemberBookResponse>> getMemberBookRank() {
        List<RankMemberBookResponse> bookRank = rankService.getBookRank();
        return ResponseEntity.ok(bookRank);
    }

    @GetMapping("/page")
    public ResponseEntity<List<RankMemberPageResponse>> getMemberPageRank() {
        List<RankMemberPageResponse> bookRank = rankService.getPageRank();
        return ResponseEntity.ok(bookRank);
    }

}
