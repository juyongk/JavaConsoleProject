package banking4;

public abstract class Account {
	
	private String accountNumber;//계좌번호
	private String name;//이름
	private int balance;//잔액
	
	
	public Account(String accountNumber, String name, int balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	// 전체계좌정보출력
	public void showAccInfo() {
		System.out.println("----계좌정보출력----");
		System.out.println("계좌번호:"+accountNumber);
		System.out.println("고객이름:"+name);
		System.out.println("잔고:"+balance);
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public boolean plusBalance(int money){
		balance += money;
		return true;
	}
	public boolean minusBalance(int money){
		balance -= money;
		return true;
	}
}
