import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Bank {
    public static List<Thread> threads = new ArrayList<>();

    private HashMap<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public void addAcc(String accNum, Account account) {
        accounts.put(accNum, account);
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {


        long sendingAccMoney = accounts.get(fromAccountNum).getMoney();
        long getterAccMoney = accounts.get(toAccountNum).getMoney();
        long sendingAccMoneyAfterSend = sendingAccMoney - amount;
        long getterAccMoneyAfterTransfet = getterAccMoney + amount;
        accounts.get(fromAccountNum).setMoney(sendingAccMoneyAfterSend);
        accounts.get(toAccountNum).setMoney(getterAccMoneyAfterTransfet);

    }


    public long getSumAllAccounts() {
        return 0;
    }
}

