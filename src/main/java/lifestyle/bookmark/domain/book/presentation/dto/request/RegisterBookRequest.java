package lifestyle.bookmark.domain.book.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterBookRequest {
    private String bookTitle;
    private Integer bookPage;
    private String authorName;
}
