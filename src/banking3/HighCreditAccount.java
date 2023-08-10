package banking3;

public class HighCreditAccount extends Account{

	double dbt;
	String creditrating;
	

	public HighCreditAccount(String accountNumber, String name, int balance, double debt, String creditRating) {
		super(accountNumber, name, balance);
		this.dbt = dbt / 100;
		this.creditrating = creditRating;
	}
//
//	public double getDbt() {
//		return dbt;
//	}
//
//	public void setDbt(double dbt) {
//		this.dbt = dbt;
//	}
//
//	public String getCreditrating() {
//		return creditrating;
//	}
//
//	public void setCreditrating(String creditrating) {
//		this.creditrating = creditrating;
//	} 	
	
	@Override
	public boolean plusBalance(int money) {
		//double dbt = getDebt() * 0.01;
		
		switch (creditrating) {
	      case "A":
	         balance = (int)(balance + (balance * dbt)+(balance * 0.07) + money);
	         break;
	      case "B":
	         balance = (int)(balance + (balance * dbt)+(balance * 0.04) + money);
	         break;
	      case "C":
	         balance = (int)(balance + (balance * dbt)+(balance * 0.02) + money);
	         break;
	      }
		return true;
	}
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : " + (int)(dbt*100) + "%");
		System.out.println("신용등급 : " + creditrating);
	}
}
