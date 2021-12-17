import java.time.LocalDate;

public class BankAccount {
    public double totalMoney = 0;


    public void put(double amountToPut) {
        if (amountToPut < 0) {
            System.out.println("Невалидная сумма денег");
        } else {
            totalMoney += amountToPut;


        }
    }

    public void take(double amountToTake) {
        if (amountToTake > totalMoney) {
            System.out.println("Недостаточно денег на счету");
        } else {
            totalMoney -= amountToTake;
        }

    }

    public double getAmount() {

        return totalMoney;
    }
}
