package lifestyle.bookmark.domain.book.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "book_page")
    private Integer bookPage;

    @Column(name = "author_name")
    private String authorName;
}
