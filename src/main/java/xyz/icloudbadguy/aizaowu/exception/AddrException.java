package xyz.icloudbadguy.aizaowu.exception;

public class AddrException extends Exception {
    public AddrException() {
    }

    public AddrException(String message) {
        super(message);
    }

    public AddrException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddrException(Throwable cause) {
        super(cause);
    }

    public AddrException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
