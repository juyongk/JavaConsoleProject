package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {

	
	public static void main(String[] args) throws MenuSelectException {

		   Scanner scan = new Scanner(System.in);
		   
		   AccountManager accMgr = new AccountManager();
		      
	         while (true) {
	        	 
	        	 accMgr.showMenu();
	        	 
	        	 try {
	        		 int selNum = scan.nextInt();
		         switch (selNum) {
		         	case MenuChoice.make:
		         		accMgr.makeAccount();
		         		break;
		         	case MenuChoice.deposit:
		         		accMgr.depositMoney();
		         		break;
		         	case MenuChoice.withdraw:
		         		accMgr.withdrawMoney();
		         		break;
		         	case MenuChoice.inquire:
		         		accMgr.showAccInfo();
		         		break;
		         	case MenuChoice.delete:
			        	accMgr.deleteAccount();
			            break;
		         	case MenuChoice.exit:
		         		System.out.println("프로그램을 종료합니다.");
		         		return;
	         		default:
	         			try {
	         				String msg = "1~6사이의 값만 입력할 수 있습니다.";
		   		    	    MenuSelectException ex = new MenuSelectException(msg);
				    	    throw ex;
	         			}
				        catch(MenuSelectException e) {
			        		 System.out.println(e.getMessage());
				        }
	         			
	         }
		         
	     
	         }
	         catch(InputMismatchException e) {
	        	 System.out.println("숫자를 입력하세요.");
	        	 scan.nextLine();
	        }
	     }
	}
}
