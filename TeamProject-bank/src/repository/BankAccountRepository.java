package repository;



// 계좌 클래스
// 소유자명, 계좌번호, 잔고로 구성
//
public class BankAccountRepository {
    private String bankOwnerName;
    private String bankAccountNumber;
    private long bankBalance;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    private String bankName;

    public String getBankOwnerName() {
        return bankOwnerName;
    }

    public void setBankOwnerName(String bankOwnerName) {
        this.bankOwnerName = bankOwnerName;
    }
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public long getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(long bankBalance) {
        this.bankBalance = bankBalance;
    }




}
