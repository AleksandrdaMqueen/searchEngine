

public class RunnerForGetBalance implements Runnable {
    private static Bank bank;
    private static String accountNum;
    public RunnerForGetBalance(Bank bank,String accountNum){
        this.bank= bank ;
        this.accountNum=  accountNum;

    }
    @Override
    public void run() {
        System.out.println(bank.getBalance(accountNum));

    }

}
