package lifestyle.bookmark.domain.member.domain;

import lifestyle.bookmark.domain.book.domain.Book;
import lifestyle.bookmark.global.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "bookId")
    private List<Book> books;

    @Column(name = "read_page")
    private Integer readPage = 0;

    @Column(name = "read_book_count")
    private Integer readBookCount = 0;

    public void updateBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addReadBookCount(Integer bookCount) {
        this.readBookCount += bookCount;
    }

    public void addReadPage(Integer readPage) {
        this.readPage += readPage;
    }
}
