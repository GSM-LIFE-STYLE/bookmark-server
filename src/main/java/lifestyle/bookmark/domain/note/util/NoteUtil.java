package lifestyle.bookmark.domain.note.util;

import lifestyle.bookmark.domain.note.domain.Note;
import lifestyle.bookmark.domain.note.presentation.dto.response.GetNoteResponse;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Component
public class NoteUtil {

    public List<GetNoteResponse>  noteListToDtoList(List<Note> notes) {
        List<GetNoteResponse> response = notes.stream().map(
                n -> new GetNoteResponse(n.getNoteTitle(), n.getNoteContent(), n.getReadPage(), n.getBook().getBookTitle()))
                .collect(Collectors.toList());
        return response;
    }
}
