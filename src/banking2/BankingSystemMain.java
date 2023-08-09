package banking2;

import java.util.Scanner;

public class BankingSystemMain {

	public static Scanner sc = new Scanner(System.in);
	
	static Account[] accountArr = new Account[50];
	
	static int accAccount = 0;
	
	public static void showMenu() {
		System.out.println("----Menu----");
		System.out.println("1.계좌개설");
		System.out.println("2.입 금");
		System.out.println("3.출 금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
		System.out.println("--------");
		System.out.println("선택:");
	}
	//계좌개설
	public static void makeAccount() {
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호:");
		String accId = sc.nextLine();
		System.out.print("고객이름:");
		String cusName = sc.nextLine();
		System.out.println("잔고:");
		int balance = sc.nextInt();
		sc.nextLine();
		accountArr[accAccount++] = new Account(accId,cusName,balance);
	      System.out.println("계좌계설이 완료되었습니다.");
	}
	//입금
	public static void depositMoney() {
		System.out.println("***입   금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.println("계좌번호:");
		String accId = sc.nextLine();
		System.out.println("입금:");
		int deposit = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i< accAccount; i++) {
	         if(accountArr[i].getAccountNumber().equals(accId)) {
	        	accountArr[i].plusBalance(deposit);
	            System.out.println("입금이 완료되었습니다.");
	            break;
	         }
		}
	}
	//출금
	public static void withdrawMoney() {
		System.out.println("***출   금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.println("계좌번호:");
		String accId = sc.nextLine();
		System.out.println("출금:");
		int money = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i< accAccount; i++) {
	         if(accountArr[i].getAccountNumber().equals(accId)) {
	        	 accountArr[i].minusBalance(money);
	        	 System.out.println("출금이 완료되었습니다.");
	            break;
	         }     
	}
 }
	//전체계좌정보출력
	public static void showAccInfo() {
		System.out.println("***계좌정보출력***");
		for(int i = 0; i<accAccount; i++) {
			accountArr[i].showAccInfo();
			System.out.println("전체계좌정보 출력이 완료되었습니다.");
	      }
	}
	
	public static void main(String[] args) {

		   Scanner scan = new Scanner(System.in);
		      
		         while (true) {
		            showMenu();
		            int selNum = scan.nextInt();
		         switch (selNum) {
		         case MenuChoice.MAKE:
		            makeAccount();
		            break;
		         case MenuChoice.deposit:
		            depositMoney();
		            break;
		         case MenuChoice.withdraw:
		            withdrawMoney();
		            break;
		         case MenuChoice.inquire:
		            showAccInfo();
		            break;
		         case MenuChoice.exit:
		            System.out.println("프로그램을 종료합니다.");
		            return;
		         }
		 }
	}
}
