package repository;


//거래내역

import java.time.*;
public class TransactionRepository{


    private String nameOfBank;
    private String accountNumber;
    private long amountOfTransaction;
    private int flagDepositOrWithdraw; //1 : deposit , -1 : withdraw;
    private LocalDate transactionTime;


    public TransactionRepository(){}
    public TransactionRepository(String nameOfBank, String accountNumber, int amountOfTransaction, int flagDepositOrWithdraw, LocalDate transactionTime){
        this.nameOfBank = nameOfBank;
        this.accountNumber = accountNumber;
        this.amountOfTransaction = amountOfTransaction;
        this.flagDepositOrWithdraw = flagDepositOrWithdraw;
        this.transactionTime = transactionTime;
    }




    public String getNameOfBank() {
        return nameOfBank;
    }
    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getAmountOfTransaction() {
        return amountOfTransaction;
    }
    public void setAmountOfTransaction(long amountOfTransaction) {
        this.amountOfTransaction = amountOfTransaction;
    }

    public int getFlagDepositOrWithdraw() {
        return flagDepositOrWithdraw;
    }
    public void setFlagDepositOrWithdraw(int flagDepositOrWithdraw) {
        this.flagDepositOrWithdraw = flagDepositOrWithdraw;
    }

    public LocalDate getTransactionTime() {
        return transactionTime;
    }
    public void setTransactionTime(LocalDate transactionTime) {
        this.transactionTime = transactionTime;
    }
}


