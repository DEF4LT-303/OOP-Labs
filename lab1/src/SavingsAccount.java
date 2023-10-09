public class SavingsAccount extends BankAccount{

    public SavingsAccount(String accountName, int accountNumber) {
        super(accountName, accountNumber);
    }

    public void addInterest(double interestRate) {
        double interest = (getBalance() * interestRate) / 100;
        deposit(interest);
    }

    @Override
    public void withdraw(double amount) {
        if(amount > 0 && amount <= getBalance()){
            super.withdraw(amount);
        }
        else System.out.println("Not enough fund...");
    }
}
