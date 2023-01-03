package lifestyle.bookmark.domain.book.service.impl;

import lifestyle.bookmark.domain.book.domain.Book;
import lifestyle.bookmark.domain.book.domain.repository.BookRepository;
import lifestyle.bookmark.domain.book.exception.AlreadyExistsBookException;
import lifestyle.bookmark.domain.book.exception.NotFoundBookException;
import lifestyle.bookmark.domain.book.presentation.dto.request.RegisterBookRequest;
import lifestyle.bookmark.domain.book.service.BookService;
import lifestyle.bookmark.domain.member.domain.Member;
import lifestyle.bookmark.domain.member.domain.repository.MemberRepository;
import lifestyle.bookmark.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final MemberFacade memberFacade;

    private void verifyBookByTitle(String title) {
        List<Book> books = memberFacade.getCurrentMember().getBooks();
        boolean isContainsBook = books.contains(bookRepository.findByBookTitle(title)
                .orElseThrow(() -> new NotFoundBookException("존재하지 않는 책입니다.")));

        if(isContainsBook)
            throw new AlreadyExistsBookException("이미 등록한 책입니다.");
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void registerBook(RegisterBookRequest request) {

        verifyBookByTitle(request.getBookTitle());

        Book book = Book.builder()
                .bookTitle(request.getBookTitle())
                .bookPage(request.getBookPage())
                .authorName(request.getAuthorName())
                .build();

        bookRepository.save(book);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBook(Integer bookId) {
        Member currentMember = memberFacade.getCurrentMember();

        List<Book> books = currentMember.getBooks();
        Book findBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundBookException("등록되지 않은 책입니다."));

        books.remove(books.indexOf(findBook));
        currentMember.updateBooks(books);

        bookRepository.deleteById(bookId);
        memberRepository.save(currentMember);
    }
}
