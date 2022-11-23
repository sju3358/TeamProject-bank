import repository.BankAccountRepository;
import service.BankService;
import presentation.UserInterface;
import repository.BankAccountRepository;
import service.BankService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService kbBankService = new BankService("국민은행");
        UserInterface UI = new UserInterface();

        String bankOwnerName1 = "배지호";
        String bankAccountNumber1 = "999-999-999";
        long bankBalance1 = 5000;
        String bankPassword1 = "3934";
        kbBankService.addAccount(bankOwnerName1,bankAccountNumber1,bankBalance1,bankPassword1);

        Scanner scan = new Scanner(System.in);






        boolean isExit = false;
        do{
            UI.run();
            int menu = scan.nextInt();
            scan.nextLine();
            switch (menu){
                case 1 :
                    System.out.println("고객님의 성명,계좌번호, 입금하실 금액을 알려주세요.");
                    System.out.println("고객님의 성명 : ");
                    String bankOwnerName = scan.nextLine();
                    System.out.println("계좌번호를 입력해 주세요 :" );
                    String bankAccountNumber = scan.nextLine();
                    System.out.println("입금하실 금액을 알려주세요 :" );
                    long bankBalance = scan.nextInt();
                    scan.nextLine();
                    System.out.println("비밀번호를 입력해 주세요 : ");
                    String bankPassword = scan.nextLine();
                    kbBankService.addAccount(bankOwnerName,bankAccountNumber,bankBalance,bankPassword);
                    break;
                case 2:
                    System.out.println("입금하실 계좌번호를 알려주세요 :  " );
                    String depositNumber = scan.nextLine();
                    System.out.println("입금하실 금액을 적어주세요 :");
                    int depositBalance = scan.nextInt();
                    System.out.println("입금이 완료되었습니다.");
                    String depositPassword = "";
                    kbBankService.depositAndWithdrawMoney(depositNumber, depositBalance,depositPassword);
                    break;
                case 3:
                    System.out.println("출금하실 계좌번호를 입력해 주세요. ");
                    String withdrawNumber = scan.nextLine();
                    System.out.println("출금하실 금액을 적어주세요 : ");
                    int withdrawBalance = scan.nextInt();
                    if (withdrawBalance > 0) {
                        withdrawBalance = withdrawBalance * -1;
                    }
                    scan.nextLine();
                    System.out.println("비밀번호를 입력해주세요 :");
                    String withdrawPassword = scan.nextLine();
                    System.out.println("출금이 완료되었습니다.");
                    kbBankService.depositAndWithdrawMoney(withdrawNumber, withdrawBalance, withdrawPassword);
                    break;
                case 4:
                    System.out.println("계좌 수정은 1번, 계좌 삭제는 2번, 계좌 잔고 확인을 하고싶으시면 3번을 눌러주세요.");
                    int Choice = scan.nextInt();
                    scan.nextLine();
                    if(Choice == 1) {
                        System.out.println("수정하실 고객님의 성명을 입력해주세요 : ");
                        String modifiedname = scan.nextLine();
                        System.out.println("수정 전 이름으로 등록되어있는 계좌번호를 입력해주세요 : ");
                        String modifiedAccountNumber = scan.nextLine();
                        System.out.println("비밀번호를 입력해주세요: ");
                        String modifiedPassword = scan.nextLine();
                        boolean flag = kbBankService.changeAccount(modifiedname, modifiedAccountNumber, modifiedPassword);
                        if(flag){
                            System.out.println("수정이 완료되었습니다.");
                        }
                    } else if (Choice == 2) {
                        System.out.println("삭제하실 계좌번호를 입력해주세요. :");
                        String deleteAccount = scan.nextLine();
                        System.out.println("비밀번호를 입력해주세요: ");
                        String deletePassword = scan.nextLine();
                        kbBankService.deleteAccount(deleteAccount,deletePassword);
                        System.out.println("삭제되었습니다. ");
                    }
                    if(Choice == 3) {
                        System.out.println("잔고 확인을 하고 싶은 계좌 번호를 입력해주세요 : ");
                        String bankAccountName = scan.nextLine();
                        System.out.println("비밀번호를 입력해주세요: ");
                        String bankAccountPassword = scan.nextLine();

                        long bankMoney = kbBankService.getAccountBalance(bankAccountName,bankAccountPassword);
                        if (bankMoney > 0) {
                            System.out.println("현재 잔액 :" + bankMoney );
                        }
                    }
                    break;
                case 5:
                    System.out.println("이름으로 계좌 조회를 하고싶으시면 1번, 계좌 번호로 계좌 조회를 하고싶으시면 2번을 눌러주세요.");
                    int searchChoice = scan.nextInt();
                    scan.nextLine();
                    if(searchChoice == 1){
                        System.out.println("이름을 입력해주세요 : ");
                        String nameSearch = scan.nextLine();
                        System.out.println("조회 결과: ");
                        kbBankService.searchAccountByName(nameSearch);
                    }
                    if(searchChoice == 2){
                        System.out.println("계좌 번호를 입력해주세요 : ");
                        String numberSearch = scan.nextLine();
                        System.out.println("조회 결과: ");
                        kbBankService.searchAccountByNumber(numberSearch);
                    }

                    break;
                case 6:
                    System.out.println("조회 결과");
                    kbBankService.listAllOfTransactions();
                    break;
                case 7:
                    System.out.println("조회 결과");
                    kbBankService.listAllOfAccounts();

                    break;
                case 8:
                    System.out.println("이용해 주셔서 감사합니다.");
                    isExit = true; break;
            }
        } while (!isExit);


    }
}
