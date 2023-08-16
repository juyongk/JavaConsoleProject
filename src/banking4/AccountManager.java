package banking4;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class AccountManager implements MenuChoice {
    private HashSet<Account> accounts;
    private int numAccounts;

    public AccountManager() {
        accounts = new HashSet<>();
        numAccounts = 0;
    }

    // 기능 관련 로직 및 메소드들...

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        manager.run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine(); // 줄바꿈 문자 처리를 위해서 사용

            switch (choice) {
                case MAKE:
                    makeAccount();
                    break;
                case DEPOSIT:
                    depositMoney();
                    break;
                case WITHDRAW:
                    withdrawMoney();
                    break;
                case INQUIRE:
                    showAccInfo();
                    break;
                case DELETE:
                    deleteAccount(sc);
                    break;
                case EXIT:
                    // 프로그램 종료 처리
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
            }
        }
    }

    
    public void makeAccount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("***신규계좌개설***");
        System.out.println("-----계좌선택------");
        System.out.println("1. 보통계좌");
        System.out.println("2. 신용신뢰계좌");
        System.out.print("선택: ");

        int accountType = sc.nextInt();
        sc.nextLine(); // 줄바꿈 문자 처리를 위해서 사용

        System.out.print("계좌번호: ");
        String accountNumber = sc.nextLine();

        System.out.print("고객이름: ");
        String customerName = sc.nextLine();

        System.out.print("잔고: ");
        int initialBalance = sc.nextInt();

        System.out.print("기본이자%(정수형태로입력): ");
        int defaultInterestRate = sc.nextInt();

        Account newAccount;

        switch (accountType) {
            case 1:
                newAccount = new NormalAccount(accountNumber, customerName, initialBalance, defaultInterestRate);
                break;
            case 2:
                System.out.print("신용등급(A,B,C 중 선택): ");
                char creditLevel = sc.next().charAt(0);
                newAccount = new HighCreditAccount(accountNumber, customerName, initialBalance, defaultInterestRate, creditLevel);
                break;
            default:
                System.out.println("잘못된 선택입니다. 계좌 개설을 취소합니다.");
                return;
        }

        if (accounts.contains(newAccount)) {
            System.out.println("중복된 계좌번호 발견되었습니다. 덮어쓰시겠습니까?(y or n)");
            String response = sc.next().toLowerCase();

            if (response.equals("y")) {
                accounts.remove(newAccount);
                accounts.add(newAccount);
                System.out.println("계좌 정보가 성공적으로 덮어쓰기되었습니다.");
            } else {
                System.out.println("계좌 정보를 유지합니다. 새로운 정보는 무시됩니다.");
            }
        } else {
            accounts.add(newAccount);
            System.out.println("계좌계설이 완료되었습니다.");
        }
    }


    

    public void showMenu() {
        System.out.println("-----Menu-----");
        System.out.println("1. 계좌개설");
        System.out.println("2. 입금");
        System.out.println("3. 출금");
        System.out.println("4. 계좌정보 출력");
        System.out.println("5. 계좌정보 삭제");
        System.out.println("6. 프로그램 종료");
        System.out.print("선택: ");
    }

    public void deleteAccount(Scanner sc) {
        System.out.println("-----계좌정보 삭제-----");
        System.out.print("삭제할 계좌번호: ");
        String accountNumber = sc.next();

        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getAccountNumber().equals(accountNumber)) {
                iterator.remove();
                System.out.println("계좌정보가 삭제되었습니다.");
                return;
            }
        }

        System.out.println("해당되는 계좌번호를 찾을 수 없습니다.");
    }

        // 메뉴 출력
    

    


    public void depositMoney() {
        Scanner sc = new Scanner(System.in);
        String accountNumber;
        int depositAmount;

        System.out.println("-----입   금-----");
        System.out.println("계좌번호와 입금할 금액을 입력하세요");

        System.out.print("계좌번호: ");
        accountNumber = sc.next();

        try {
            System.out.print("입금액: ");
            depositAmount = sc.nextInt();

            if (depositAmount < 0) {
                System.out.println("음수를 입금할 수 없습니다.");
            } else if (depositAmount % 500 != 0) {
                System.out.println("입금액은 500원 단위로 가능합니다.");
            } else {
                Iterator<Account> iterator = accounts.iterator();
                while (iterator.hasNext()) {
                    Account account = iterator.next();
                    if (account.getAccountNumber().equals(accountNumber)) {
                        account.deposit(depositAmount);
                        System.out.println("입금이 완료되었습니다.");
                        return;
                    }
                }
                System.out.println("해당 계좌번호를 찾을 수 없습니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("문자 입력이 안됩니다. 금액을 정수로 입력해주세요.");
            sc.nextLine(); // 이전 입력을 비워주는 용도
        }
    }



    public void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        String accountNumber;
        int withdrawAmount;

        System.out.println("-----출   금-----");
        System.out.println("계좌번호와 출금할 금액을 입력하세요");

        System.out.print("계좌번호: ");
        accountNumber = sc.next();

        try {
            System.out.print("출금액: ");
            withdrawAmount = sc.nextInt();

            if (withdrawAmount < 0) {
                System.out.println("음수를 출금할 수 없습니다.");
            } else if (withdrawAmount % 1000 != 0) {
                System.out.println("출금액은 1000원 단위로 가능합니다.");
            } else {
                Iterator<Account> iterator = accounts.iterator();
                while (iterator.hasNext()) {
                    Account account = iterator.next();
                    if (account.getAccountNumber().equals(accountNumber)) {
                        if (account.getBalance() >= withdrawAmount) {
                            account.withdraw(withdrawAmount);
                            System.out.println("출금이 완료되었습니다.");
                        } else {
                            System.out.println("잔액이 부족합니다. 금액전체를 출금할까요? (YES/NO)");
                            String response = sc.next().toUpperCase();
                            if (response.equals("YES")) {
                                account.withdraw(account.getBalance());
                                System.out.println("금액 전체를 출금하였습니다.");
                            } else {
                                System.out.println("출금 요청이 취소되었습니다.");
                            }
                        }
                        return;
                    }
                }
                System.out.println("해당 계좌번호를 찾을 수 없습니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("문자 입력이 안됩니다. 금액을 정수로 입력해주세요.");
            sc.nextLine(); // 이전 입력을 비워주는 용도
        }
    }



    public void showAccInfo() {
        System.out.println("-----계좌 정보 출력-----");

        if (accounts.isEmpty()) {
            System.out.println("등록된 계좌 정보가 없습니다.");
        } else {
            Iterator<Account> iterator = accounts.iterator();
            while (iterator.hasNext()) {
                Account account = iterator.next();
                System.out.println(account); // 객체를 직접 전달하여 toString 메서드 호출
            }
            System.out.println("전체 계좌 정보 출력이 완료되었습니다.");
        }
    }

}