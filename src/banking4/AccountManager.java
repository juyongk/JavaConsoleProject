package banking4;

import java.util.InputMismatchException;
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
		System.out.println("5.계좌 삭제");
		System.out.println("6.프로그램종료");
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

	    try {
	        System.out.println("입금:");
	        int deposit = sc.nextInt();
	        sc.nextLine();

	        // 입금 금액 확인
	        if (deposit < 0) {
	            System.out.println("음수를 입금할 수 없습니다. 양수의 금액을 입력해주세요.");
	            return;
	        } else if (deposit % 500 != 0) {
	            System.out.println("입금액은 500원 단위로 가능합니다. Ex) 1000, 1500원 입금가능 "+(deposit)+ "원 입금불가");
	        }

	        boolean accountFound = false;
	        for (int i = 0; i < accAccount; i++) {
	            if (accountArr[i].getAccountNumber().equals(accId)) {
	                accountArr[i].plusBalance(deposit);
	                System.out.println("입금이 완료되었습니다.");
	                accountFound = true;
	                break;
	            }
	        }
	        if (!accountFound) {
	            System.out.println("해당 계좌번호를 찾을 수 없습니다.");
	        }
	    } catch (InputMismatchException e) {
	        sc.nextLine();
	        System.out.println("금액 입력 시 문자를 입력할 수 없습니다. 정수를 입력해주세요.");
	    }
	}
	public void withdrawMoney() {
	    System.out.println("***출   금***");
	    System.out.println("계좌번호와 출금할 금액을 입력하세요");
	    System.out.println("계좌번호:");
	    String accId = sc.nextLine();

	    try {
	        System.out.println("출금:");
	        int money = sc.nextInt();
	        sc.nextLine();

	        // 출금 금액 확인
	        if (money < 0) {
	            System.out.println("음수를 출금할 수 없습니다. 양수의 금액을 입력해주세요.");
	            return;
	        } else if (money % 1000 != 0) {
	            System.out.println("출금은 1000원 단위로만 가능합니다. Ex) 2000원 출금가능, 1100원 출금불가");
	            return;
	        }

	        boolean accountFound = false;
	        for (int i = 0; i < accAccount; i++) {
	            if (accountArr[i].getAccountNumber().equals(accId)) {
	                accountFound = true;

	                // 잔고 확인
	                if (accountArr[i].getBalance() < money) {
	                    System.out.println("잔고가 부족합니다. 금액 전체를 출금할까요? (YES/NO)");
	                    String answer = sc.nextLine();

	                    if (answer.equalsIgnoreCase("YES")) {
	                        accountArr[i].minusBalance(accountArr[i].getBalance());
	                        System.out.println("금액 전체 출금 처리 완료");
	                    } else if (answer.equalsIgnoreCase("NO")) {
	                        System.out.println("출금 요청 취소");
	                    } else {
	                        System.out.println("올바른 답변을 입력하세요. 요청이 취소되었습니다.");
	                    }
	                } else {
	                    accountArr[i].minusBalance(money);
	                    System.out.println("출금이 완료되었습니다.");
	                }
	                break;
	            }
	        }
	        if (!accountFound) {
	            System.out.println("해당 계좌번호를 찾을 수 없습니다.");
	        }
	    } catch (InputMismatchException e) {
	        sc.nextLine();
	        System.out.println("금액 입력 시 문자를 입력할 수 없습니다. 정수를 입력해주세요.");
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