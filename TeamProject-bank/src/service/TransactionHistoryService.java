package service;


import repository.TransactionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class TransactionHistoryService {

    //싱글톤 패턴
    private static TransactionHistoryService service;

    private TransactionHistoryService(){
        transactionLists = new ArrayList<>();
    }
    public static TransactionHistoryService getInstance(){
        if(service == null){
            service = new TransactionHistoryService();
        }
        return service;
    }




    //필드
    private ArrayList<TransactionRepository> transactionLists;



    //메소드
    public void addTransaction(TransactionRepository transaction){
        this.transactionLists.add(transaction);
    }


    public void addTransaction(String nameOfBank, String accountNumber, long amountOfTransaction, int flagDepositOrWithdraw, LocalDate transactionTime  ){
        TransactionRepository transaction = new TransactionRepository();

        transaction.setNameOfBank(nameOfBank);
        transaction.setAccountNumber(accountNumber);
        transaction.setAmountOfTransaction(amountOfTransaction);
        transaction.setTransactionTime(transactionTime);

        this.transactionLists.add(transaction);
    }


    public void listTransactions(){
        Iterator<TransactionRepository> iteratorOfTransaction = this.transactionLists.iterator();
        while(iteratorOfTransaction.hasNext()){
            TransactionRepository transaction = iteratorOfTransaction.next();

            System.out.println("-----------------------------");
            System.out.println("은행명 : " + transaction.getNameOfBank());
            System.out.println("계좌번호 : " + transaction.getAccountNumber());
            System.out.println("입출금내역 : " + transaction.getAmountOfTransaction());
            System.out.println("거래일시 : " + transaction.getTransactionTime().toString());

        }
    }
}
