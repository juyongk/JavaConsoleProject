package banking2;

import java.util.Scanner;

import banking1.Account;

public class AccountManager {
	
	public static Scanner sc = new Scanner(System.in);
	
	static Account[] accountArr = new Account[50];
	
	static int accAccount = 0;

	public static void makeAccount() {
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호:");
		String accId = sc.nextLine();
		System.out.print("고객이름:");
		String cusName = sc.nextLine();
		System.out.println("잔고:");
		int balance = sc.nextInt();
		System.out.println("기본이자%(정수형태로입력):");
		int debt = sc.nextInt();
		sc.nextLine();
		accountArr[accAccount++] = new Account(accId,cusName,balance);
	      System.out.println("계좌계설이 완료되었습니다.");
	}
	
//	양평루피 ㅎㅇ
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
	}
}
