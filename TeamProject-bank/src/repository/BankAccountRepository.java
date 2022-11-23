package repository;



// 계좌 클래스
// 소유자명, 계좌번호, 잔고로 구성
//
public class BankAccountRepository {

    private String bankName;
    private String bankOwnerName;
    private String bankAccountNumber;
    private long bankBalance;


    public BankAccountRepository(String bankName, String bankOwnerName, String bankAccountNumber, long bankBalance){
        this.bankName = bankName;
        this.bankOwnerName = bankOwnerName;
        this.bankAccountNumber = bankAccountNumber;
        this.bankBalance = bankBalance;
    }

    public String getBankName() {
        return bankName;
    }
    public String getBankOwnerName() {
        return bankOwnerName;
    }
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }
    public long getBankBalance() {
        return bankBalance;
    }

    public void addBankBalance(long money) {
        this.bankBalance += money;
    }

    public String toString() {

        String to_string = null;

        to_string += "-----------------------------\n";
        to_string += "소유자명 : " + this.bankOwnerName + "\n";
        to_string += "계좌번호 : " + this.bankAccountNumber + "\n";
        to_string += "잔   고 : " + this.bankBalance + "\n";

        return to_string;
    }
}