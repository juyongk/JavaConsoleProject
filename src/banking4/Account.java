package banking4;

import java.util.Objects;

public abstract class Account {
    private String accountNumber; // 계좌번호
    private String customerName; // 예금주명
    private int balance; // 잔액

    public String getAccountNumber() {
        return accountNumber;
    }
    public void deposit(int amount) {
        balance += amount;
    }
    
    public int getBalance() {
        return balance;
    }
    public void setBalance(int newBalance) {
        balance = newBalance;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
        } else {
            balance -= amount;
        }
    }
    
    public Account(String accountNumber, String customerName, int balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    // 기존 메서드들...

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Account other = (Account) obj;
        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return String.format("계좌번호: %s\n고객이름: %s\n잔고: %d\n", accountNumber, customerName, balance);
    }
}