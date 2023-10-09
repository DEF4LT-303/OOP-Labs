import java.util.ArrayList;

public class BankAccount {

    public int accountNumber;
    public String accountName;
    public double balance = 0;
    public ArrayList<Transaction> transactions = new ArrayList<>();

    public BankAccount(String accountName, int accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            Transaction trx = new Transaction("Deposit", balance, amount);
            transactions.add(trx);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount < balance) {
                balance -= amount;
                Transaction trx = new Transaction("Withdraw", balance, amount);
                transactions.add(trx);
            }
            else {
                balance -= amount;
                Transaction trx = new Transaction("Withdraw", balance, amount);
                transactions.add(trx);
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printStatement() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);

        System.out.println("\nTransaction History:\n");
//        System.out.println("Length :\n" + transactions.size());
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
