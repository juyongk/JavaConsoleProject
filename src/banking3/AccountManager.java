package banking3;

import java.util.Scanner;

public class AccountManager {
	
	public Scanner sc = new Scanner(System.in);
	
	Account[] accountArr = new Account[50];
	
	int accAccount = 0;

	
	public void showMenu() {
		System.out.println("----Menu----");
		System.out.println("1.계좌개설");
		System.out.println("2.입 금");
		System.out.println("3.출 금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
		System.out.println("--------");
		System.out.print("선택:");
	}
	
	public void makeAccount() {
		System.out.println("***신규계좌개설***");
		System.out.println("---계좌선택---");
		
		System.out.println("1.보통계좌:");
		
		System.out.println("2.신용신뢰계좌:");
		
		System.out.print("선택:");
		int choice = sc.nextInt();
		sc.nextLine();
		
		System.out.print("계좌번호:");
		String accId = sc.nextLine();
		
		System.out.print("고객이름:");
		String cusName = sc.nextLine();
		
		System.out.print("잔고:");
		int balance = sc.nextInt();
		sc.nextLine();
		
		System.out.print("기본이자%(정수형태로입력):");
		int debt = sc.nextInt();
		sc.nextLine();
		
		if(choice==1) {
			accountArr[accAccount++]= new NormalAccount(accId,cusName,balance,debt);
		}
		else if(choice==2) {
			System.out.println("신용등급(A,B,C등급):");
			String creditrating = sc.nextLine();
			
			accountArr[accAccount++]= 
					new HighCreditAccount(accId, cusName, balance, debt, creditrating);
		}
	}
	
		public void depositMoney() {
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
	
		public void withdrawMoney() {
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
		public void showAccInfo() {
			System.out.println("***계좌정보출력***");
			for(int i = 0; i<accAccount; i++) {
				accountArr[i].showAccInfo();
				System.out.println("전체계좌정보 출력이 완료되었습니다.");
		    }
		}
	
	}
