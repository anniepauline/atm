package atm;

public class MinimumBalanceException extends Exception {
    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return "MinimumBalanceException: Cannot withdraw < 100";
    }
}
