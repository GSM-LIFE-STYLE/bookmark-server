package lifestyle.bookmark.domain.book.exception;

import lifestyle.bookmark.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundBookException extends RuntimeException{

    private final ErrorCode errorCode;

    public NotFoundBookException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_BOOK;
    }
}
