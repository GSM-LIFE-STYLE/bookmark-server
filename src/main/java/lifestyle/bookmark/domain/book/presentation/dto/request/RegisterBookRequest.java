package lifestyle.bookmark.domain.book.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterBookRequest {
    @NotEmpty
    private String bookTitle;
    @NotEmpty
    private Integer bookPage;
    @NotEmpty
    private String authorName;
}
