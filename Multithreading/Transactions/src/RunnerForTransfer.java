public class RunnerForTransfer implements Runnable {

    Bank bank;
    int amount;
    String fromAccountNum;
    String toAccountNum;
    public RunnerForTransfer(Bank bank, int amount, String fromAccountNum, String toAccountNum){
        this.bank = bank;
        this.amount = amount;
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;

    }

    @Override
    public void run() {
       bank.transfer(fromAccountNum,toAccountNum,amount);
       if (amount > 50000){
           System.out.println("Checking");
       }
        System.out.println("Ready");
    }

    public int getAmount() {
        return amount;
    }

    public String getFromAccountNum() {
        return fromAccountNum;
    }

    public String getToAccountNum() {
        return toAccountNum;
    }
}
