package banking2;

public class NormalAccount extends Account{

	private int debt;

	public NormalAccount(String accountNumber, String name, int balance, int debt) {
		super(accountNumber, name, balance);
		this.debt = debt;
	}

	public int getDebt() {
		return debt;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}
}
