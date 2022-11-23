package service;


import exceptions.NoAccountException;
import exceptions.NotEnoughException;

import repository.BankAccountRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//계좌 관리
public class BankAccountService
{

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


    private HashMap<String,BankAccountRepository> bankAccountsList;



    public void addAccount(String bankName, String bankOwnerName, String bankAccountNumber, long bankBalance, String password){
        BankAccountRepository newAccount = new BankAccountRepository(
                bankName,
                bankOwnerName,
                bankAccountNumber,
                bankBalance,
                password
        );
        bankAccountsList.put(bankAccountNumber, newAccount);
    }
    public boolean deleteAccount(String bankAccountNumber, String password){

        try{
            BankAccountRepository account = bankAccountsList.get(bankAccountNumber);

            if(account == null)
                throw new NoAccountException("해당 계좌가 존재하지 않습니다.");
            if(account.checkPassword(password) == false)
                throw new NoAccountException("비밀번호가 일치하지 않습니다");

            boolean flag = bankAccountsList.remove(bankAccountNumber, account);

            if(flag == false)
                throw new NoAccountException("삭제 실패");

            return true;
        }
        catch (NoAccountException e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean modifyAccount(String bankName, String ownerName, String bankAccountNumber, String password){

        try{
            BankAccountRepository account = this.bankAccountsList.get(bankAccountNumber);

            if(account == null)
                throw new NoAccountException("해당 계좌가 존재하지 않습니다.");
            if(account.checkPassword(password) == false)
                throw new NoAccountException("비밀번호가 일치하지 않습니다");

            boolean flag = bankAccountsList.remove(bankAccountNumber, account);

            if(flag == false)
                throw new NoAccountException("수정 실패");

            addAccount(bankName,ownerName,bankAccountNumber,account.getBankBalance(),password);

            return true;
        }catch (NoAccountException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public long getAccountBalance(String bankAccountNumber, String password){

        try{
            BankAccountRepository account = bankAccountsList.get(bankAccountNumber);


            if(account == null)
                throw new NoAccountException("계좌가 존재하지 않습니다.");
            if(account.checkPassword(password) == false)
                throw new NoAccountException("비밀번호가 일치하지 않습니다");

            return account.getBankBalance();
        }
        catch (NoAccountException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public boolean depositAndWithdraw(String bankAccountNumber , int amount, String password){
        try {
            BankAccountRepository bankAccount = bankAccountsList.get(bankAccountNumber);

            if (bankAccount == null)
                throw new NoAccountException("계좌가 존재하지 않습니다.");

            if(amount < 0 && bankAccount.checkPassword(password) == false)
                throw new NoAccountException("비밀번호가 틀렸습니다.");

            if (bankAccount.getBankBalance() + amount < 0 )
                throw new NotEnoughException("잔액이 충분하지 않습니다.");

            bankAccount.addBankBalance(amount);

            return true;

        } catch (NoAccountException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (NotEnoughException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    public ArrayList<BankAccountRepository> getAccountsByName(String name){
        ArrayList<BankAccountRepository> result = new ArrayList<>();

        Iterator<String> iteratorOfAccount = this.bankAccountsList.keySet().iterator();
        while (iteratorOfAccount.hasNext()) {
            BankAccountRepository Account = this.bankAccountsList.get(iteratorOfAccount.next());

            if(Account.checkOwnerName(name) == true){
                result.add(Account);
            }
        }

        return result;
    }
    public BankAccountRepository getAccountsByNumber(String bankAccountNumber){
        try {
            BankAccountRepository account = bankAccountsList.get(bankAccountNumber);

            if (account == null)
                throw new NoAccountException("해당 계좌가 존재하지 않습니다.");

            return account;
        }
        catch (NoAccountException e){
            System.out.println(e.getMessage());
            return null;
        }

    }


    public void listAccounts() {
        Iterator<String> iteratorOfAccount = this.bankAccountsList.keySet().iterator();

        while (iteratorOfAccount.hasNext()) {
            BankAccountRepository account = this.bankAccountsList.get(iteratorOfAccount.next());
            System.out.println(account.toString());
        }
    }

}
