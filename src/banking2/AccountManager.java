package banking2;

import java.util.Scanner;

public class AccountManager {
	
	public Scanner sc = new Scanner(System.in);
	
	Account[] accountArr = new Account[50];
	
	int accAccount = 0;

	
	
	public  void makeAccount() {
		System.out.println("***신규계좌개설***");
		System.out.print("보통계좌:");
		String normalAcc = sc.nextLine();
		
		System.out.print("신용계좌:");
		String highAcc = sc.nextLine();
		
		System.out.print("선택:");
		int choice = sc.nextInt();
		sc.nextLine();
		
		System.out.print("계좌번호:");
		String accId = sc.nextLine();
		
		System.out.print("고객이름:");
		String cusName = sc.nextLine();
		
		System.out.println("잔고:");
		int balance = sc.nextInt();
		sc.nextLine();
		
		System.out.println("기본이자%(정수형태로입력):");
		int debt = sc.nextInt();
		sc.nextLine();
	    
	    
//		Account acct = null;
		switch(choice) {
		case 1:
			accountArr[accAccount++] = new NormalAccount(accId,cusName,balance,debt);
			 break;

		case 2:
			System.out.print("신용등급(A,B,C등급):");
			String creditrating = sc.nextLine(); 
			acct = new HighCreditAccount(accId,cusName,balance,debt,creditrating);
			break;
		
	
		accountArr[accAccount++] = acct;
				
				System.out.println("계좌가 생성되었습니다.");
			}
	}
	
}
