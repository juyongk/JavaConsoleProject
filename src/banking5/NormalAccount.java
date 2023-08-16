package banking5;
import java.io.Serializable;

public class NormalAccount extends Account implements Serializable {
    private double interestRate;

    public NormalAccount(String accountNumber, String name, int balance, double interestRatePercent) {
        super(accountNumber, name, balance);
        this.interestRate = interestRatePercent / 100; // 백분율을 소수로 변환
    }

    @Override
    public void deposit(int amount) {
        int interest = (int) (getBalance() * interestRate);
        setBalance(getBalance() + interest + amount);
    }

    // 출금 메서드 추가
    public void withdraw(int amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("잔고가 부족합니다.");
        }
    }

    // toString 메서드 수정
    @Override
    public String toString() {
        return String.format("계좌번호: %s\n고객이름: %s\n잔고: %d\n기본이자>%.0f%%\n", getAccountNumber(), getCustomerName(), getBalance(), interestRate * 100);
    }
}
