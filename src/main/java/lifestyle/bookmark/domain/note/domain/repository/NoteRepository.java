package lifestyle.bookmark.domain.note.domain.repository;

import lifestyle.bookmark.domain.member.domain.Member;
import lifestyle.bookmark.domain.note.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByMember(Member member);
}
