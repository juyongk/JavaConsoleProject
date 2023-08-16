package banking4;

public class HighCreditAccount extends Account {
    private int defaultInterestRate;
    private char creditGrade;
    private double creditInterestRate;

    public HighCreditAccount(String accountNumber, String customerName, int initialBalance, int defaultInterestRate, char creditGrade) {
        super(accountNumber, customerName, initialBalance);
        this.defaultInterestRate = defaultInterestRate;
        this.creditGrade = Character.toUpperCase(creditGrade); // creditGrade를 대문자로 변경

        switch (creditGrade) {
            case 'A':
                creditInterestRate = 0.07;
                break;
            case 'B':
                creditInterestRate = 0.04;
                break;
            default:
                creditInterestRate = 0.02;
        }
    }

    @Override
    public void deposit(int amount) {
        int interest = (int) (getBalance() * defaultInterestRate);
        int additionalInterest = (int) (getBalance() * creditInterestRate);
        setBalance(getBalance() + interest + additionalInterest + amount);
    }
    
  
    @Override
    public String toString() {
        return String.format("고객이름>%s\n잔고>%d\n기본이자>%d%%\n신용등급>%c\n", getCustomerName(), getBalance(), defaultInterestRate, creditGrade);
    }
}
