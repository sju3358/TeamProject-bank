package service;


import repository.TransactionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class TransactionHistoryService {

    private static ArrayList<TransactionRepository> transactionLists;

    //싱글톤 패턴
    public TransactionHistoryService(){
        if(transactionLists == null)
            transactionLists = new ArrayList<>();
    }

    public void addTransaction(TransactionRepository transaction){
        transactionLists.add(transaction);
    }


    public void addTransaction(String nameOfBank, String accountNumber, long amountOfTransaction, int flagDepositOrWithdraw, LocalDate transactionTime  ){
        TransactionRepository transaction = new TransactionRepository();

        transaction.setNameOfBank(nameOfBank);
        transaction.setAccountNumber(accountNumber);
        transaction.setAmountOfTransaction(amountOfTransaction);
        transaction.setFlagDepositOrWithdraw(flagDepositOrWithdraw);
        transaction.setTransactionTime(transactionTime);

        transactionLists.add(transaction);
    }

    public void listTransactions(){
        Iterator<TransactionRepository> iteratorOfTransaction = transactionLists.iterator();
        while(iteratorOfTransaction.hasNext()){
            TransactionRepository transaction = iteratorOfTransaction.next();

            String flag = null;
            if(transaction.getFlagDepositOrWithdraw() == 1)
                flag = "+";
            else if(transaction.getFlagDepositOrWithdraw() == -1)
                flag = "-";

            System.out.println("은행명 : " + transaction.getNameOfBank());
            System.out.println("계좌번호 : " + transaction.getAccountNumber());

            if(flag != null)
                System.out.println("입출금내역 : " + flag + transaction.getAmountOfTransaction());
            else
                System.out.println("입출금내역이 없습니다.");

            System.out.println("거래일시 : " + transaction.getTransactionTime().toString());

        }
    }
}
