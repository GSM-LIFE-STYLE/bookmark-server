package lifestyle.bookmark.domain.auth.exception;

import lifestyle.bookmark.global.exception.ErrorCode;
import lombok.Getter;
import org.yaml.snakeyaml.emitter.EmitterException;

@Getter
public class EmailExistsException extends RuntimeException{

    private final ErrorCode errorCode;

    public EmailExistsException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXIST_EMAIL;
    }
}
