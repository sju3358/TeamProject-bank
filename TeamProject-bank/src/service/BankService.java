package service;


import repository.BankAccountRepository;
import repository.TransactionRepository;

import java.time.LocalDate;

//은행서비스
public class BankService {


    private TransactionHistoryService transactionHistoryService;
    private BankAccountService bankAccountService;

    public BankService(){
        transactionHistoryService = TransactionHistoryService.getInstance();
        bankAccountService = BankAccountService.getInstance();
    }

    // 기능 1. 계좌번호 등록 , 계좌번호는 정규표현식으로 제한.
    // 기능 2. 계좌 수정
    // 기능 3. 계좌 삭제
    // 기능 4. 계좌 검색 (소유자 명으로)

    //입출금기능
    public void depositMoney(BankAccountRepository account, int amount){

        try {
            bankAccountService.depositAndWithdraw(account.getBankAccountNumber(),amount);

            //잔고 변동시 트렌젝션 기록
            LocalDate date = LocalDate.now();
            transactionHistoryService.addTransaction(
                    new TransactionRepository(
                            account.getBankName(),
                            account.getBankAccountNumber(),
                            amount,
                            date
                    )
            );
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }


    //송금기능

    // 기능 5. 모든 계좌목록 조회
    public void listAllOfAccounts(){
        System.out.println("계좌 목록 조회");
        bankAccountService.listAccounts();
    }

    // 기능 6. 모든 거래내역 조회
    public void listAllOfTransactions(){
        System.out.println("거래 내역 조회");
        transactionHistoryService.listTransactions();
    }
}
