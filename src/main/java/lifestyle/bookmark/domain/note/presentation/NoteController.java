package lifestyle.bookmark.domain.note.presentation;

import lifestyle.bookmark.domain.note.presentation.dto.request.WriteNoteRequest;
import lifestyle.bookmark.domain.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("note")
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<Void> writeNote(WriteNoteRequest request) {
        noteService.writeNote(request);
        return ResponseEntity.ok().build();
    }
}
