package service;


import repository.TransactionRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
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


    private ArrayList<TransactionRepository> transactionLists;


    public void addTransaction(String nameOfBank, String accountNumber, long amountOfTransaction, LocalDateTime transactionTime  ){
        TransactionRepository transaction = new TransactionRepository(
                nameOfBank,
                accountNumber,
                amountOfTransaction,
                transactionTime
        );

        this.transactionLists.add(transaction);
    }
    public String getListOfTransactions(){
        Iterator<TransactionRepository> iteratorOfTransaction = this.transactionLists.iterator();
        String result = "";
        while(iteratorOfTransaction.hasNext()){
            TransactionRepository transaction = iteratorOfTransaction.next();
            result += transaction.toString();
        }
        return result;
    }
}
