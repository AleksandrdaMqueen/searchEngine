import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    public static boolean isMonthAgo(){

         LocalDate lastInCome = LocalDate.now();
  
        return false;
    }

    @Override
    public void take(double amountToTake) {
        if(isMonthAgo() && amountToTake < totalMoney) {
            super.take(amountToTake);
        }else{
            System.out.println("Еще не прошел месяц");
        }
    }
}
