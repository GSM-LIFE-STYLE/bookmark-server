package lifestyle.bookmark.domain.book.service.impl;

import lifestyle.bookmark.domain.book.domain.Book;
import lifestyle.bookmark.domain.book.domain.repository.BookRepository;
import lifestyle.bookmark.domain.book.exception.AlreadyExistsBookException;
import lifestyle.bookmark.domain.book.exception.NotFoundBookException;
import lifestyle.bookmark.domain.book.presentation.dto.request.RegisterBookRequest;
import lifestyle.bookmark.domain.book.presentation.dto.request.UpdateBookRequest;
import lifestyle.bookmark.domain.book.presentation.dto.response.BookResponse;
import lifestyle.bookmark.domain.book.service.BookService;
import lifestyle.bookmark.domain.book.util.BookUtil;
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
    private final BookUtil bookUtil;

    private void verifyBookByTitle(String title) {
        List<Book> books = memberFacade.getCurrentMember().getBooks();
        boolean isContainsBook = books.contains(bookRepository.findByBookTitle(title)
                .orElseThrow(() -> new NotFoundBookException("존재하지 않는 책입니다.")));

        if(isContainsBook)
            throw new AlreadyExistsBookException("이미 등록한 책입니다.");
    }

    private void updateBookEntity(Book book , UpdateBookRequest request) {
        if(request.getBookTitle() != null)
            book.updateBookTitle(request.getBookTitle());
        if(request.getBookPage() != null)
            book.updateBookPage(request.getBookPage());
        if(request.getAuthorName() != null)
            book.updateAuthorName(request.getAuthorName());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void registerBook(RegisterBookRequest request) {

        verifyBookByTitle(request.getBookTitle());

        Book book = Book.builder()
                .bookTitle(request.getBookTitle())
                .bookPage(request.getBookPage())
                .authorName(request.getAuthorName())
                .member(memberFacade.getCurrentMember())
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBook(Integer bookId, UpdateBookRequest request) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new NotFoundBookException("등록되지 않은 책입니다."));
        updateBookEntity(book, request);

        bookRepository.save(book);
    }

    @Override
    public BookResponse lookUpBook(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new NotFoundBookException("등록되지 않은 책입니다."));

        return BookResponse.builder()
                .bookTitle(book.getBookTitle())
                .bookPage(book.getBookPage())
                .authorName(book.getAuthorName())
                .build();
    }

    @Override
    public List<BookResponse> lookUpAllBooks() {
        List<Book> books = bookRepository.findAll();

        if(books.isEmpty())
            throw new NotFoundBookException("등록된 책이 존재하지 않습니다.");

        List<BookResponse> response = bookUtil.toBookDtoList(books);
        return response;
    }

}
