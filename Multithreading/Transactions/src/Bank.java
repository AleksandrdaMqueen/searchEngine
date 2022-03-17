import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Bank {
    public static List<Thread> threads = new ArrayList<>();

    private HashMap<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();


    public void addAcc(String accNum, Account account) {
        accounts.put(accNum, account);
    }



    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);


        synchronized (fromAccount.compareTo(toAccount) > 0 ? toAccount : fromAccount) {
            synchronized (fromAccount.compareTo(toAccount) > 0 ? fromAccount : toAccount) {
                if (amount > 50000){
                    try {
                        boolean isFraud2 = isFraud(fromAccountNum,toAccountNum,amount);
                        if (isFraud2){
                            System.out.println("Перевод денег не может быть осуществлен");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                long sendingAccMoney = accounts.get(fromAccountNum).getMoney();
                long getterAccMoney = accounts.get(toAccountNum).getMoney();
                long sendingAccMoneyAfterSend = sendingAccMoney - amount;
                long getterAccMoneyAfterTransfet = getterAccMoney + amount;
                accounts.get(fromAccountNum).setMoney(sendingAccMoneyAfterSend);
                accounts.get(toAccountNum).setMoney(getterAccMoneyAfterTransfet);
            }
        }

    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }


    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }




    public long getSumAllAccounts() {
        return 0;
    }


}
