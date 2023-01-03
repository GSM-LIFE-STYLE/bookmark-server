package lifestyle.bookmark.domain.book.domain.repository;

import lifestyle.bookmark.domain.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
