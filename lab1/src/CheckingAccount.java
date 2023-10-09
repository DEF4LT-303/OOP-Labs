public class CheckingAccount extends BankAccount {

    public double overDraft = 0;

    public CheckingAccount(String accountName, int accountNumber) {
        super(accountName, accountNumber);
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }

    @Override
    public void withdraw(double amount) {
        if(amount > 0 && amount <= (getBalance() + overDraft)) {
            super.withdraw(amount);
        }
        else System.out.println("Exceeds overdraft limit...");
    }

}
