package atm;

import java.util.Scanner;

public class Bank {
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
        this.Balnc += amount;
        System.out.println("Amount deposited:" + this.Balnc);
    }

    public void withdraw() {
        System.out.println("Enter amount to withdraw:");
        int amount = sc.nextInt();
        if (amount > Balnc) {
            System.out.println("Insufficient balance");
        } else {
            this.Balnc -= amount;
            System.out.println("Amount withdrawn:" + this.Balnc);
        }
    }

    public double getBalnc() {
        return this.Balnc;
    }

    public boolean auth() {
        trials = 0;
        while (trials < 3) {

            System.out.println("Enter Bank password:");
            this.p = sc.nextLine();

            if (p.equals(pwd)) {
                authenticated = true;
                System.out.println("Successfully logged in!");
                return authenticated;
            } else {
                trials++;
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
        System.out.println("Enter new Bank password:");
        pwd = sc.nextLine();

        System.out.println("Re-enter new Bank password:");
        p = sc.nextLine();
        if (p.equals(pwd)) {
            System.out.println("Successfully changed Bank password!");
            System.out.println("Login to continue...");
            auth();
        } else {
            System.out.println("Passwords do not match.Try again!");
            reset();
        }
    }
}
