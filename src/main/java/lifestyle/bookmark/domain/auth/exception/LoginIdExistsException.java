package lifestyle.bookmark.domain.auth.exception;

import lifestyle.bookmark.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class LoginIdExistsException extends RuntimeException{

    private final ErrorCode errorCode;

    public LoginIdExistsException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXIST_ID;
    }
}
