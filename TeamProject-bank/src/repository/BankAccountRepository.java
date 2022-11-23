package repository;



// 계좌 클래스
// 소유자명, 계좌번호, 잔고로 구성
//
public class BankAccountRepository {
    private String bankUseName;

    public String getBankUseName() {
        return bankUseName;
    }

    public void setBankUseName(String bankUseName) {
        this.bankUseName = bankUseName;
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

    private String bankAccountNumber;
    private long bankBalance;


}
