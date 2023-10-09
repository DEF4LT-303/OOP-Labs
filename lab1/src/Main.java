import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account Name: ");
        String accName = sc.nextLine();
        System.out.print("Enter account Number: ");
        int accNum = sc.nextInt();


        SavingsAccount acc1 = new SavingsAccount(accName, accNum);
        CheckingAccount acc2 = new CheckingAccount(accName, accNum);



        while(true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Saving Account");
            System.out.println("2. Checking Account");

            int choice = sc.nextInt();

            if(choice == 1) {
                while(true) {
                    System.out.println("\nChoose an option for saving account:");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Print Statement");
                    System.out.println("4. Get Balance");
                    System.out.println("5. Add Interest");
                    System.out.println("6. Exit");

                    int choice2 = sc.nextInt();

                    switch (choice2) {
                        case 1:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = sc.nextDouble();
                            acc1.deposit(depositAmount);
                            break;

                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = sc.nextDouble();
                            acc1.withdraw(withdrawAmount);
                            break;

                        case 3:
                            acc1.printStatement();
                            break;

                        case 4:
                            System.out.println("Current Balance: " + acc1.getBalance());
                            break;

                        case 5:
                            double interest = sc.nextDouble();
                            acc1.addInterest(interest);
                            System.out.println("Added Interest: " + interest);

                        case 6:
                            return;

                        default:
                            System.out.println("Invalid choice. Please select a valid option.");
                    }
                }
            }
                else if(choice == 2) {
                    while(true) {
                        System.out.println("\nChoose an option for checking account:");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Print Statement");
                        System.out.println("4. Get Balance");
                        System.out.println("5. Add Overdraft");
                        System.out.println("6. Exit");

                        int choice3 = sc.nextInt();

                        switch (choice3) {
                            case 1:
                                System.out.print("Enter amount to deposit: ");
                                double depositAmount = sc.nextDouble();
                                acc2.deposit(depositAmount);
                                break;

                            case 2:
                                System.out.print("Enter amount to withdraw: ");
                                double withdrawAmount = sc.nextDouble();
                                acc2.withdraw(withdrawAmount);
                                break;

                            case 3:
                                acc2.printStatement();
                                break;

                            case 4:
                                System.out.println("Current Balance: " + acc2.getBalance());
                                break;

                            case 5:
                                double overdraft = sc.nextDouble();
                                acc2.setOverDraft(overdraft);
                                System.out.println("Overdraft set: " + overdraft);

                            case 6:
                                return;

                            default:
                                System.out.println("Invalid choice. Please select a valid option.");
                        }
                    }
                }
                else {
                    System.out.println("Invalid Option");
                    break;
                }
            }

        }


//        acc2.setOverDraft(30);
//
//        acc2.deposit(5);
//        acc2.withdraw(55);
//
//        acc2.printStatement();

//        acc1.addInterest(10);
//        System.out.println("Total Balance:" + acc2.getBalance());

}

