package service;


import repository.TransactionRepository;

//은행서비스
public class BankService {

    private TransactionHistoryService transtionHistroy;

    public BankService(){
        transtionHistroy = TransactionHistoryService.getInstance();
    }

    // 기능 1. 계좌번호 등록 , 계좌번호는 정규표현식으로 제한.
    // 기능 2. 계좌 수정
    // 기능 3. 계좌 삭제
    // 기능 4. 계좌 검색 (소유자 명으로)
    // 기능 5. 모든 계좌목록 조회




    // 기능 6. 모든 거래내역 조회
    public void listAllOfTransactions(){
        System.out.println("거래 내역 조회");
        transtionHistroy.listTransactions();
    }
}
