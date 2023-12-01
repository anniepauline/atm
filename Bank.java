package atm;

import java.util.Scanner;

public class Bank implements BankInf {
    private long Accno;
    private double Balnc;
    private static long count = 159805000l;
    private String pwd = "12345";
    private String p;
    int trials;
    boolean authenticated = false;

    Scanner sc = new Scanner(System.in);

    Bank() {
        this.Accno = count += 1;
    }

    @Override
    public String toString() {
        return "Account no is: " + this.Accno + " \nAccount Balance is :" + this.Balnc;
    }

    public void deposit() {
        System.out.println("Enter amount to Deposit:");
        int amount = sc.nextInt();
        try {
            if (amount <= 100) {
                throw new MinimumBalanceException();
            } else {
                this.Balnc += amount;
                System.out.println("Amount deposited:" + this.Balnc);
            }
        } catch (MinimumBalanceException e) {
            System.out.println("MinimumDepositException: Enter value greater than 100");
            this.deposit();
        }

    }

    public void withdraw() {
        System.out.println("Enter amount to withdraw:");
        int amount = sc.nextInt();
        try {
            if (amount > Balnc) {
                throw new InSufficientBalanceException();
            } else {
                this.Balnc -= amount;
                System.out.println("Amount withdrawn:" + amount);
            }
            if (amount < 100) {
                throw new MinimumBalanceException();
            }

        } catch (InSufficientBalanceException e) {
            System.out.println("Insufficient Balance.");
        } catch (MinimumBalanceException e) {
            System.out.println("MinimumWithDrawException: Enter value greater than 100");
            this.withdraw();
        }

    }

    public double getBalnc() {
        return this.Balnc;
    }

    public void validateAccNo() {
        System.out.println("Enter Bank Account number:");
        long id = sc.nextLong();
        try {
            if ((id != this.Accno)) {
                throw new AccountNumberException();
            }

        } catch (AccountNumberException e) {
            System.out.println("Wrong account number!");
            this.validateAccNo();
        }
    }

    public boolean auth() {
        while (trials < 3) {

            System.out.println("Enter Bank password:");
            this.p = sc.next();
            try {

                if (!(p.equals(pwd))) {
                    trials++;
                    throw new PasswordNotMatchException();
                } else {
                    authenticated = true;
                    System.out.println("Successfully logged in!");
                    return authenticated;
                }
            } catch (PasswordNotMatchException e) {
                System.out.println("Incorrect Password,Retry!");
            }
        }
        authenticated = false;
        System.out.println("OOPS! Would you like to change your password?(y/n)");
        String input = sc.nextLine();

        if (input.contentEquals("y") || input.contentEquals("Y")) {
            reset();
        } else {
            System.out.println("Login failed!");
            return false;

        }
        return authenticated;

    }

    public void reset() {
        System.out.println("Enter you old pin");
        String oPin = sc.nextLine();
        try {
            if (!oPin.equals(pwd)) {
                throw new PasswordNotMatchException();
            } else
                System.out.println("Enter new Bank password:");
            pwd = sc.nextLine();
        } catch (PasswordNotMatchException e) {
            System.out.println("Password does not match");
            this.reset();
        }

        System.out.println("Re-enter new Bank password:");
        p = sc.nextLine();
        if (p.equals(pwd)) {
            System.out.println("Successfully changed Bank password!");
            System.out.println("Login to continue...");
            auth();
        }
        try {
            if (!p.equals(pwd)) {
                throw new PasswordNotMatchException();
            }
        } catch (PasswordNotMatchException e) {
            System.out.println("Passwords do not match.Try again!");
            reset();
        }

    }
}
