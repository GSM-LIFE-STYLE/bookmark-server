package lifestyle.bookmark.domain.book.service;

import lifestyle.bookmark.domain.book.presentation.dto.request.RegisterBookRequest;
import lifestyle.bookmark.domain.book.presentation.dto.request.UpdateBookRequest;
import lifestyle.bookmark.domain.book.presentation.dto.response.BookResponse;

import java.util.List;

public interface BookService {
    void registerBook(RegisterBookRequest request);
    void deleteBook(Integer bookId);
    BookResponse lookUpBook(Integer bookId);
    List<BookResponse> lookUpAllBooks();
    void updateBook(Integer bookId, UpdateBookRequest request);
}
