package lifestyle.bookmark.domain.email.exception;

import lifestyle.bookmark.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class MisMatchAuthCodeException extends RuntimeException{
    private final ErrorCode errorCode;

    public MisMatchAuthCodeException(String message) {
        super(message);
        this.errorCode = ErrorCode.MISMATCH_AUTH_CODE;
    }

}
