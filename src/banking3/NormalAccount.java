package banking3;

public class NormalAccount extends Account{

	private double debt;

	public NormalAccount(String accountNumber, String name, int balance, int debt) {
		super(accountNumber, name, balance);
		this.debt = debt;
	}

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}
	
	
	   
   @Override
   public boolean plusBalance(int money) {
//	  double dbt = debt * 0.01;
	   int bal = super.getBalance();
	   int sum = (int)(bal + bal*debt/100 + money);
	   super.setBalance(sum);
      return true;
   }
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : " + debt + "%");
	}
	
}
