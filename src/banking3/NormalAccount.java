package banking3;

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
	
	
	   
   @Override
   public boolean plusBalance(int money) {
	  double dbt = debt * 0.01;
      balance=(int)(balance+(balance*dbt)+money);
      return true;
   }
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : " + debt + "%");
	}
	
}
