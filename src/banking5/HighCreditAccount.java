package banking5;

public class HighCreditAccount extends Account{

	private double dbt;
	private String creditrating;
	

	public HighCreditAccount(String accountNumber, String name, int balance, int debt, String creditRating) {
		super(accountNumber, name, balance);
		this.dbt = (double)debt;
		this.creditrating = creditRating;
	}
//
	public double getDbt() {
		return dbt;
	}

	public void setDbt(double dbt) {
		this.dbt = dbt;
	}

	public String getCreditrating() {
		return creditrating;
	}

	public void setCreditrating(String creditrating) {
		this.creditrating = creditrating;
	} 	
	
	@Override
	public boolean plusBalance(int money) {
		//double dbt = getDebt() * 0.01;
		int bal = super.getBalance();
		int sum = (int)(bal + bal*dbt/100 + bal*getGradeInt(creditrating)/100 + money);
		super.setBalance(sum);
		return true;
	}
	public int getGradeInt (String creditrating) {
		switch (creditrating) {
	      case "A":  case "a":
	         return 7; 
	      case "B":case "b":
	         return 4; 
	      case "C":case "c":
	         return 2; 
	      default: return 0;
	      }
	}
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : " + (int)dbt + "%");
		System.out.println("신용등급 : " + creditrating);
	}
}
