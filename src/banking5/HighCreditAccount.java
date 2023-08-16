package banking5;
import java.io.Serializable;

public class HighCreditAccount extends NormalAccount implements Serializable {
    private char creditGrade;
    private double creditInterestRate;
    private double defaultInterestRate;

    public HighCreditAccount(String accountNumber, String customerName, int initialBalance, double defaultInterestRate, char creditGrade) {
        super(accountNumber, customerName, initialBalance, defaultInterestRate);
        this.creditGrade = creditGrade;
        this.defaultInterestRate = defaultInterestRate / 100;

        switch (creditGrade) {
            case 'A':
                this.creditInterestRate = 0.07;
                break;
            case 'B':
                this.creditInterestRate = 0.04;
                break;
            default:
                this.creditInterestRate = 0.02;
        }
    }

    @Override
    public void deposit(int amount) {
        int interestAmount = (int) (getBalance() * defaultInterestRate);
        int additionalInterestAmount = (int) (getBalance() * creditInterestRate);
        int totalAmount = getBalance() + interestAmount + additionalInterestAmount + amount;
        setBalance(totalAmount);
    }
    
  
    @Override
    public String toString() {
    	return String.format("계좌번호>%s\n고객이름>%s\n잔고>%d\n기본이자>%d%%\n신용등급>%c\n", getAccountNumber(), getCustomerName(), getBalance(), (int)(defaultInterestRate * 100), creditGrade);
    }
}
