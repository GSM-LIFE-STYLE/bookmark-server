package lifestyle.bookmark.domain.note.domain.repository;

import lifestyle.bookmark.domain.note.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
