import repository.BankAccountRepository;
import service.BankService;

public class Main {
    public static void main(String[] args) {
        BankService bs = new BankService();

        String bankName = "농협";
        String bankOwner = "조성락";
        String bankNumber = "72727272";
        long balance = 100;
        String password = "1234";
        bs.addAccount(bankName,bankOwner,bankNumber,balance,password);
        bs.listAllOfAccounts();


        bankName = "국민";
        bankOwner = "조성룡";
        bankNumber = "72327272";
        balance = 100;
        password = "1234";
        bs.addAccount(bankName,bankOwner,bankNumber,balance,password);
        bs.listAllOfAccounts();


        bs.depositAndWithdrawMoney("72327272",1000);
        bs.depositAndWithdrawMoney("72727272",1230);
        bs.listAllOfAccounts();

        bs.listAllOfTransactions();
    }
}