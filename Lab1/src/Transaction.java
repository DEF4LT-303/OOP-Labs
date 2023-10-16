import java.util.Date;

public class Transaction {

    public Date date;
    public String type;
    public double amount;
    public double balance;
    public Transaction(String type, double balance, double amount) {
        this.date = new Date();
        this.type = type;
        this.balance = balance;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\n" +
                "Type: " + type + "\n" +
                "Amount: $" + amount + "\n" +
                "Balance: $" + balance + "\n";
    }

}
