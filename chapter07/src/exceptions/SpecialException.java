package exceptions;

public class SpecialException extends Exception {
    public SpecialException(String msg, Exception cause) {
        super(msg, cause);
    }
}
