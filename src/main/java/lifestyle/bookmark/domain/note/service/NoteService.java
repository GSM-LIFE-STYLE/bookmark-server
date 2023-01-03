package lifestyle.bookmark.domain.note.service;

import lifestyle.bookmark.domain.note.presentation.dto.request.WriteNoteRequest;

public interface NoteService {
    void writeNote(WriteNoteRequest request);
    void deleteNote(Integer noteId);
}
