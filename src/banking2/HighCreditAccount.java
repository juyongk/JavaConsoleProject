package banking2;

public class HighCreditAccount extends Account{

	private char creditrating;

	public HighCreditAccount(String accountNumber, String name, int balance, int debt, char creditRating) {
		super(accountNumber, name, balance);
		this.creditrating = creditrating;
	}

	public char getCreditrating() {
		return creditrating;
	}

	public void setCreditrating(char creditrating) {
		this.creditrating = creditrating;
	} 	
}
