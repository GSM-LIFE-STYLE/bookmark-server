package lifestyle.bookmark.domain.rank.exception;

import lifestyle.bookmark.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundRankException extends RuntimeException {

    private final ErrorCode errorCode;

    public NotFoundRankException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_RANK;
    }
}
