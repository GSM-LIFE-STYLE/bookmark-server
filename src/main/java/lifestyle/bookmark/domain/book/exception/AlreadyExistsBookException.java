package lifestyle.bookmark.domain.book.exception;

import lifestyle.bookmark.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class AlreadyExistsBookException extends RuntimeException {

    private final ErrorCode errorCode;


    public AlreadyExistsBookException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXISTS_BOOK;
    }
}
