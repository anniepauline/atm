package atm;

public class InSufficientBalanceException extends Exception {
    @Override
    public String getMessage() {
        return "InSufficientBalanceException";
    }
}
