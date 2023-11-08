package atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int option;
        Bank b1 = new Bank();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== WELCOME! ===");
        boolean auth = b1.auth();
        while (auth) {
            System.out.println("--------------------------------");
            System.out.println("Select an  Option:");
            System.out.println("--------------------------------");
            System.out.println("1.Withdraw:");
            System.out.println("2.Deposit");
            System.out.println("3.Check Balance");
            System.out.println("4.Account details");
            System.out.println("5.Exit");
            System.out.println("--------------------------------");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    b1.withdraw();
                    System.out.println();
                    break;

                case 2:
                    b1.deposit();
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Current balance is: " + b1.getBalnc());
                    System.out.println();
                    break;

                case 4:
                    System.out.println(b1);
                    System.out.println();
                    break;
                case 5:
                    auth = false;
                    break;
                default:
                    System.out.println("You entered an Invalid option.");
                    System.out.println();
                    break;
            }
        }
    }
}
