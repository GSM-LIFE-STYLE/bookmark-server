package lifestyle.bookmark.domain.book.service;

import lifestyle.bookmark.domain.book.presentation.dto.request.RegisterBookRequest;

public interface BookService {
    void registerBook(RegisterBookRequest request);
}
