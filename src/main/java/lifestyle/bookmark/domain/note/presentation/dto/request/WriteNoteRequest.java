package lifestyle.bookmark.domain.note.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class WriteNoteRequest {
    @NotEmpty
    private final String noteTitle;
    @NotEmpty
    private final String noteContent;
    @NotEmpty
    private final Integer readPage;
    @NotEmpty
    private final Integer bookId;
}
