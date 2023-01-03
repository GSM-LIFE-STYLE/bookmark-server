package lifestyle.bookmark.domain.book.exception;

import lifestyle.bookmark.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class UnregisterBookException extends RuntimeException{
    private final ErrorCode errorCode;

    public UnregisterBookException(String message) {
        super(message);
        this.errorCode = ErrorCode.UNREGISTER_BOOK;
    }
}
