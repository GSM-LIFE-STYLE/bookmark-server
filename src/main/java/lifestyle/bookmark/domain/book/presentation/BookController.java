package lifestyle.bookmark.domain.book.presentation;

import lifestyle.bookmark.domain.book.presentation.dto.request.RegisterBookRequest;
import lifestyle.bookmark.domain.book.presentation.dto.request.UpdateBookRequest;
import lifestyle.bookmark.domain.book.presentation.dto.response.BookResponse;
import lifestyle.bookmark.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponse>> lookUpAllBooks() {
        List<BookResponse> response = bookService.lookUpAllBooks();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> registerBook(RegisterBookRequest request) {
        bookService.registerBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> lookUpBook(@PathVariable Integer id) {
        BookResponse response = bookService.lookUpBook(id);
        return ResponseEntity.ok(response);
    }

   @PatchMapping("/{id}")
   public ResponseEntity<Void> updateBook(@PathVariable Integer id, @RequestBody UpdateBookRequest request) {
        bookService.updateBook(id, request);
        return ResponseEntity.ok().build();
   }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }


}
