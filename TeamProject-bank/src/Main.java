import repository.BankAccountRepository;
import service.BankService;
import presentation.UserInterface;
import repository.BankAccountRepository;
import service.BankService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        UserInterface UI = new UserInterface();
        UI.run();

        Scanner scan = new Scanner(System.in);

        boolean isExit = false;
        do{
            int menu = Integer.parseInt(scan.nextLine());
            switch (menu){
                case 1 :
                    System.out.println("개설하실 계좌의 은행,고객님의 성명,계좌번호,입금하실 금액을 알려주세요.");

                    break;
                case 2:
                    System.out.println("입금 하실 계좌 번호를 알려주세요 :  " );

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8: isExit = true; break;
            }
        } while (!isExit);


    }
}
