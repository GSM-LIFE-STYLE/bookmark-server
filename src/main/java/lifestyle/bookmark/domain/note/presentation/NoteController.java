package lifestyle.bookmark.domain.note.presentation;

import lifestyle.bookmark.domain.note.presentation.dto.request.WriteNoteRequest;
import lifestyle.bookmark.domain.note.presentation.dto.response.GetNoteResponse;
import lifestyle.bookmark.domain.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<GetNoteResponse> lookUpNote(@PathVariable Integer id) {
        GetNoteResponse response = noteService.lookUpNote(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Integer id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
