package lifestyle.bookmark.domain.book.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRequest {
    private String bookTitle;
    private Integer bookPage;
    private String authorName;
}
