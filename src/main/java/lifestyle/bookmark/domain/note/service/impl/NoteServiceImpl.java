package lifestyle.bookmark.domain.note.service.impl;

import lifestyle.bookmark.domain.book.domain.Book;
import lifestyle.bookmark.domain.book.domain.repository.BookRepository;
import lifestyle.bookmark.domain.book.exception.NotFoundBookException;
import lifestyle.bookmark.domain.book.exception.UnregisterBookException;
import lifestyle.bookmark.domain.member.domain.Member;
import lifestyle.bookmark.domain.member.facade.MemberFacade;
import lifestyle.bookmark.domain.note.domain.repository.NoteRepository;
import lifestyle.bookmark.domain.note.presentation.dto.request.WriteNoteRequest;
import lifestyle.bookmark.domain.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final MemberFacade memberFacade;
    private final NoteRepository noteRepository;
    private final BookRepository bookRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void writeNote(WriteNoteRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new NotFoundBookException("존재하지 않은 책입니다."));

        // 독서 노트 등록 -> 책에 관한 독서 노트 -> 책 있는거맞는데 연관관계가 멤버랑 있는지 어캐앎?
        // 책의 멤버와 노트의 멤버가 같은지 비교?

        Member currentMember = memberFacade.getCurrentMember();

        if(!book.getMember().equals(currentMember))
            throw new UnregisterBookException("등록하지 않은 책입니다.");


    }
}
