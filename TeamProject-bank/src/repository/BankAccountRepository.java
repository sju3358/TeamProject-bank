package repository;



// 계좌 클래스
// 소유자명, 계좌번호, 잔고로 구성
//
public class BankAccountRepository {

    private String bankName;
    private String bankOwnerName;
    private String bankAccountNumber;
    private long bankBalance;
    private String password;


    public BankAccountRepository(String bankName, String bankOwnerName, String bankAccountNumber, long bankBalance, String password){
        this.bankName = bankName;
        this.bankOwnerName = bankOwnerName;
        this.bankAccountNumber = bankAccountNumber;
        this.bankBalance = bankBalance;
        this.password = password;
    }



    public long getBankBalance() {
        return bankBalance;
    }



    public void addBankBalance(long money) {
        this.bankBalance += money;
    }

    public boolean checkOwnerName(String name){
        if(this.bankOwnerName.compareTo(name) == 0)
            return true;
        else
            return false;
    }
    public boolean checkPassword(String password){
        if(this.password.compareTo(password) == 0)
            return true;
        else
            return false;
    }
    public String toString() {

        String to_string = "";

        to_string += "-----------------------------\n";
        to_string += "은행이름 : " + this.bankName + "\n";
        to_string += "소유자명 : " + this.bankOwnerName + "\n";
        to_string += "계좌번호 : " + this.bankAccountNumber + "\n";
        to_string += "잔   고 : " + this.bankBalance + "\n";

        return to_string;
    }
}