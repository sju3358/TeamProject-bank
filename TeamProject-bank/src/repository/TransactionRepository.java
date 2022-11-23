package repository;


//거래내역

import java.time.*;
public class TransactionRepository{


    private String nameOfBank;
    private String accountNumber;
    private long amountOfTransaction;
    private LocalDate transactionTime;

    public TransactionRepository(String nameOfBank, String accountNumber, long amountOfTransaction, LocalDate transactionTime){
        this.nameOfBank = nameOfBank;
        this.accountNumber = accountNumber;
        this.amountOfTransaction = amountOfTransaction;
        this.transactionTime = transactionTime;
    }

    public String toString() {

        String to_string = null;

        to_string += "-----------------------------\n";
        to_string += "은행명 : " + this.nameOfBank + "\n";
        to_string += "계좌번호 : " + this.accountNumber + "\n";
        to_string += "입출금내역 : " + this.amountOfTransaction + "\n";
        to_string += "거래일시 : " + this.transactionTime.toString() + "\n";

        return to_string;
    }
}


