package atm;

public class PasswordNotMatchException extends Exception {
    public String getMessage() {
        return "PasswordNotMatchException";
    }
}
