package lifestyle.bookmark.domain.book.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @Builder
@RequiredArgsConstructor
public class BookResponse {
    private final String bookTitle;
    private final Integer bookPage;
    private final String authorName;
}
