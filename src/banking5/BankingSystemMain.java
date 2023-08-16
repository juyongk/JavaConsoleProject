package banking5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountManager accountManager = new AccountManager();

        while (true) {
            accountManager.showMenu();

            try {
                System.out.print("선택하세요 : ");
                int choice = sc.nextInt();

                if (choice < MenuChoice.MAKE || choice > MenuChoice.EXIT) {
                    throw new IllegalArgumentException("지정된 범위 외의 숫자 선택");
                }

                switch (choice) {
                    case MenuChoice.MAKE:
                        accountManager.makeAccount();
                        break;
                    case MenuChoice.DEPOSIT:
                        accountManager.depositMoney();
                        break;
                    case MenuChoice.WITHDRAW:
                        accountManager.withdrawMoney();
                        break;
                    case MenuChoice.INQUIRE:
                        accountManager.showAccInfo();
                        break;
                    case MenuChoice.EXIT:
                        System.out.println("프로그램을 종료합니다.");
                        sc.close(); 
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("문자 입력이 안됩니다. 정수를 입력해주세요.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                sc.nextLine(); 
            }
        }
    }
}
