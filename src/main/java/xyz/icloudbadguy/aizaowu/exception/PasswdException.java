package xyz.icloudbadguy.aizaowu.exception;

public class PasswdException extends Exception{
    public PasswdException() {
    }

    public PasswdException(String message) {
        super(message);
    }

    public PasswdException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswdException(Throwable cause) {
        super(cause);
    }

    public PasswdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
