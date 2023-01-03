package lifestyle.bookmark.domain.book.service.impl;

import lifestyle.bookmark.domain.book.domain.repository.BookRepository;
import lifestyle.bookmark.domain.book.presentation.dto.request.RegisterBookRequest;
import lifestyle.bookmark.domain.book.service.BookService;
import lifestyle.bookmark.domain.member.domain.repository.MemberRepository;
import lifestyle.bookmark.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final MemberFacade memberFacade;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void registerBook(RegisterBookRequest request) {

    }
}
