package lifestyle.bookmark.domain.note.domain;

import lifestyle.bookmark.domain.book.domain.Book;
import lifestyle.bookmark.domain.member.domain.Member;
import lifestyle.bookmark.global.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Note extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "note_id", nullable = false)
    private Integer noteId;

    @Column(name = "note_title")
    private String noteTitle;

    @Column(name = "note_content")
    private String noteContent;

    @Column(name = "read_page")
    private Integer readPage;

    @OneToOne
    @JoinColumn(name = "book")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member")
    private Member member;
}
