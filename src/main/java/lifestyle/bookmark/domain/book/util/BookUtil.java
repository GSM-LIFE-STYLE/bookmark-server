package lifestyle.bookmark.domain.book.util;

import lifestyle.bookmark.domain.book.domain.Book;
import lifestyle.bookmark.domain.book.presentation.dto.response.BookResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookUtil {

    public List<BookResponse> toBookDtoList(List<Book> books) {
        List<BookResponse> bookDtoList = books.stream()
                .map(b -> new BookResponse(b.getBookTitle(), b.getBookPage(), b.getAuthorName()))
                .collect(Collectors.toList());
        return bookDtoList;
    }
}
