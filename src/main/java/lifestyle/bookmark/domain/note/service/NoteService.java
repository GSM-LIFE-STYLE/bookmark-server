package lifestyle.bookmark.domain.note.service;

import lifestyle.bookmark.domain.note.presentation.dto.request.WriteNoteRequest;
import lifestyle.bookmark.domain.note.presentation.dto.response.GetNoteResponse;

import java.util.List;

public interface NoteService {
    void writeNote(WriteNoteRequest request);
    void deleteNote(Integer noteId);
    GetNoteResponse lookUpNote(Integer noteId);
    List<GetNoteResponse> lookUpNotes();
}
