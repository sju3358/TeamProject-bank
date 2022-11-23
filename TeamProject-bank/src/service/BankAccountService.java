package service;


import repository.BankAccountRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//계좌 관리
public class BankAccountService
{
    //싱글톤 패턴
    private static BankAccountService service;
    private BankAccountService(){
        bankAccountsList = new HashMap();
    }
    public static BankAccountService getInstance(){
        if(service == null){
            service = new BankAccountService();
        }
        return service;
    }

    //필드
    private HashMap<String,BankAccountRepository> bankAccountsList;


    //메소드

    //기능 1. 입금, 출금 기능
    public void depositAndWithdraw(String bankAccountNumber , int amount){
        BankAccountRepository bankAccount = bankAccountsList.get(bankAccountNumber);

        if(bankAccount == null)
            throw new NullPointerException("계좌가 존재하지 않습니다.");
        else if(amount < 0 && bankAccount.getBankBalance() < amount)
            throw new IllegalStateException("잔액이 충분하지 않습니다.");
        else
            bankAccount.setBankBalance(bankAccount.getBankBalance() + amount);
    }

    // 기능 2. 잔고 확인 기능(소유주만 잔고확인)
    //추가기능 2) 계좌 잔고 확인시 잔고(기존잔고 + 입금금액 x 적용이율)가 표시됨
    public long getAccountBalance(String bankAccountNumber){
        BankAccountRepository account = bankAccountsList.get(bankAccountNumber);

        if(account != null)
            throw new NullPointerException("계좌가 존재하지 않습니다.");
        else
            return account.getBankBalance();
    }


    // 계좌 목록 조회
    public void listAccounts() {
        Iterator<String> iteratorOfAccount = this.bankAccountsList.keySet().iterator();

        while (iteratorOfAccount.hasNext()) {
            BankAccountRepository Account = this.bankAccountsList.get(iteratorOfAccount.next());
            System.out.println("-----------------------------");
            System.out.println("소유자명 : " + Account.getBankOwnerName());
            System.out.println("계좌번호 : " + Account.getBankAccountNumber());
            System.out.println("잔   고 : " + Account.getBankBalance());
        }
    }
}
