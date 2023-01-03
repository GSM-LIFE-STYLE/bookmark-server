package lifestyle.bookmark.domain.book.service.impl;

import lifestyle.bookmark.domain.book.domain.repository.BookRepository;
import lifestyle.bookmark.domain.book.presentation.dto.request.RegisterBookRequest;
import lifestyle.bookmark.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void registerBook(RegisterBookRequest request) {

    }
}
