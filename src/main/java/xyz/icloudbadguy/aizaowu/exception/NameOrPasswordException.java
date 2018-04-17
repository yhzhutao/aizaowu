package xyz.icloudbadguy.aizaowu.exception;

public class NameOrPasswordException extends Exception{
    public NameOrPasswordException() {
    }

    public NameOrPasswordException(String message) {
        super(message);
    }

    public NameOrPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameOrPasswordException(Throwable cause) {
        super(cause);
    }

    public NameOrPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
