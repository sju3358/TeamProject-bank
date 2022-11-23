package service;

import repository.BankAccountRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

//은행서비스
public class BankService {


    private TransactionHistoryService transactionHistoryService;
    private BankAccountService bankAccountService;

    public BankService(){
        transactionHistoryService = TransactionHistoryService.getInstance();
        bankAccountService = BankAccountService.getInstance();
    }


    /**
     * 계좌 등록 메소드
     * @param bankName (String)
     * @param bankOwnerName (String)
     * @param bankAccountNumber (String)
     * @param bankBalance (long)
     */
    public void addAccount(String bankName, String bankOwnerName, String bankAccountNumber, long bankBalance, String password){
        bankAccountService.addAccount(bankName,bankOwnerName,bankAccountNumber,bankBalance,password);
    }


    /**
     * 계좌 수정 메소드
     * @param bankName (String)
     * @param bankOwnerName (String)
     * @param bankAccountNumber (String)
     * @param bankBalance (long)
     * @param password (String)
     */
    public void changeAccount(String bankName, String bankOwnerName, String bankAccountNumber, long bankBalance, String password){
        deleteAccount(bankAccountNumber);
        addAccount(bankName,bankOwnerName,bankAccountNumber,bankBalance,password);
    }

    /**
     * 계좌 삭제 메소드
     * @param bankAccountNumber (String)
     */
    public void deleteAccount(String bankAccountNumber){

        boolean flag = bankAccountService.deleteAccount(bankAccountNumber);

            if(flag == true)
                System.out.println("삭제 성공");
    }

    /**
     * 계좌 이름으로 검색 메소드
     * @param name (String)
     */
    public void searchAccount(String name){

        ArrayList<BankAccountRepository> accounts = bankAccountService.getAccountsByName(name);

        Iterator<BankAccountRepository> iteratorOfAccount = accounts.iterator();

        System.out.println("계좌 검색 결과");

        while(iteratorOfAccount.hasNext()){
            BankAccountRepository account = iteratorOfAccount.next();
            System.out.println(account.toString());
        }
    }

    /**
     * 계좌 입출금 메소드
     * @param BankAccountNumber (String)
     *  @param amount (int)
     */
    public void depositAndWithdrawMoney(String BankAccountNumber, int amount){

        boolean flag = bankAccountService.depositAndWithdraw(BankAccountNumber,amount);

        if(flag == true) {
            BankAccountRepository account = bankAccountService.getAccountsByBankAccountNumber(BankAccountNumber);
            //잔고 변동시 트렌젝션 기록
            LocalDate date = LocalDate.now();
            transactionHistoryService.addTransaction(
                    account.getBankName(),
                    account.getBankAccountNumber(),
                    amount,
                    date);
        }
    }

    /**
     * 잔액 조회 메소드
     * @param bankAccountNumber (String)
     *  @param password (String)
     */
    public long getAccountBalance(String bankAccountNumber, String password){
        return bankAccountService.getAccountBalance(bankAccountNumber, password);
    }

    // 기능 6. 송금기능


    /**
     * 모든 계좌 리스트
     */
    public void listAllOfAccounts(){
        System.out.println("계좌 목록 조회");
        bankAccountService.listAccounts();
    }

    /**
     * 모든 거래내역 리스트
     */
    public void listAllOfTransactions(){
        System.out.println("거래 내역 조회");
        transactionHistoryService.listTransactions();
    }
}
