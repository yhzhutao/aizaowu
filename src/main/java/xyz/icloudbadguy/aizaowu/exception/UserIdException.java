package xyz.icloudbadguy.aizaowu.exception;

public class UserIdException extends Exception{
    public UserIdException() {
    }

    public UserIdException(String message) {
        super(message);
    }

    public UserIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIdException(Throwable cause) {
        super(cause);
    }

    public UserIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
