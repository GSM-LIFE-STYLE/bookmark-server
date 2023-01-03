package lifestyle.bookmark.domain.note.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @Builder
@RequiredArgsConstructor
public class GetNoteResponse {
    private final String noteTitle;
    private final String noteContent;
    private final Integer readPage;
    private final String bookTitle;
}
