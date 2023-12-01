package atm;

public interface BankInf {
    public void reset();

    public boolean auth();

    public void validateAccNo();

    public double getBalnc();

    public void withdraw();

    public void deposit();

    // public void updatePin();

}
