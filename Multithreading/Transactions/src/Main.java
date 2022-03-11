

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Map<String, Account> map = new HashMap<>();
        Bank VTB = new Bank();
        List<Thread> threads = new ArrayList<>();


        Account account = new Account();
        account.setMoney(50000);

        Account account1 = new Account();
        account1.setMoney(100);
        account1.setMoney(20);
        VTB.addAcc(account.getAccNumber(), account);
        RunnerForTransfer runner1 = new RunnerForTransfer(VTB, 50000000, account.getAccNumber(), account1.getAccNumber());

        threads.add(new Thread(runner1));
        threads.forEach(thread -> {
            if (runner1.getAmount() > 50000) {
                try {
                    if (VTB.isFraud(runner1.getFromAccountNum(), runner1.getToAccountNum(), runner1.getAmount())) {
                        thread.interrupt();
                        System.out.println("deny");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                thread.start();
                try {
                    Thread.currentThread().sleep(100);
                    System.out.println(account.getMoney());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

}
