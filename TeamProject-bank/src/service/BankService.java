package service;

import java.time.LocalDateTime;

//은행서비스
public class BankService {

    private String bankName;

    private TransactionHistoryService transactionHistoryService;
    private BankAccountService bankAccountService;

    public BankService(String bankName){
        this.bankName = bankName;
        transactionHistoryService = TransactionHistoryService.getInstance();
        bankAccountService = BankAccountService.getInstance();
    }


    /**
     * 계좌 등록 메소드
     * @param bankOwnerName (String)
     * @param bankAccountNumber (String)
     * @param bankBalance (long)
     */
    public void addAccount(String bankOwnerName, String bankAccountNumber, long bankBalance, String password){
        bankAccountService.addAccount(this.bankName,bankOwnerName,bankAccountNumber,bankBalance,password);
    }

    /**
     * 계좌 수정 메소드
     * @param bankOwnerName (String)
     * @param bankAccountNumber (String)
     * @param password (String)
     */
    public boolean changeAccount(String bankOwnerName, String bankAccountNumber, String password){

        boolean flag = bankAccountService.modifyAccount(this.bankName,bankOwnerName,bankAccountNumber,password);

        if(flag== true)
            return true;
        else
            return false;
    }

    /**
     * 계좌 삭제 메소드
     * @param bankAccountNumber (String)
     */
    public boolean deleteAccount(String bankAccountNumber, String password){

        boolean flag = bankAccountService.deleteAccount(bankAccountNumber, password);
        if(flag== true)
            return true;
        else
            return false;

    }

    /**
     * 잔액 조회 메소드
     * @param bankAccountNumber (String)
     *  @param password (String)
     */
    public long getAccountBalance(String bankAccountNumber, String password){
        return bankAccountService.getAccountBalance(bankAccountNumber, password);
    }

    /**
     * 계좌 이름으로 검색 메소드
     * @param name (String)
     */
    public void searchAccountByName(String name){
        System.out.println(bankAccountService.getStringFromListOfAccount(bankAccountService.getAccountsByName(name)));
    }

    /**
     * 계좌 번호로 검색 메소드
     * @param bankAccountNumber
     */
    public void searchAccountByNumber(String bankAccountNumber){
        if(bankAccountService.getAccountsByNumber(bankAccountNumber) != null)
            System.out.println(bankAccountService.getAccountsByNumber(bankAccountNumber));
    }

    /**
     * 계좌 입출금 메소드
     * @param BankAccountNumber (String)
     * @param amount (int)
     * @param password (String)
     */
    public boolean depositAndWithdrawMoney(String BankAccountNumber, int amount , String password){

        boolean flag = false;
        flag = bankAccountService.depositAndWithdraw(BankAccountNumber,amount, password);

        if(flag == true) {
            //잔고 변동시 트렌젝션 기록
            LocalDateTime date = LocalDateTime.now();
            transactionHistoryService.addTransaction(
                    this.bankName,
                    BankAccountNumber,
                    amount,
                    date);
        }

        return flag;
    }


    // 기능 6. 송금기능


    /**
     * 모든 계좌 리스트
     */
    public void listAllOfAccounts(){
        System.out.println(bankAccountService.getListOfAccounts());
    }

    /**
     * 모든 거래내역 리스트
     */
    public void listAllOfTransactions(){
        System.out.println(transactionHistoryService.getListOfTransactions());
    }

}
