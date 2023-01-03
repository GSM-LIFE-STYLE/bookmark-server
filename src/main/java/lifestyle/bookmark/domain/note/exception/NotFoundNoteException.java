package lifestyle.bookmark.domain.note.exception;

import lifestyle.bookmark.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundNoteException extends RuntimeException {

    private final ErrorCode errorCode;

    public NotFoundNoteException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_NOTE;
    }
}
