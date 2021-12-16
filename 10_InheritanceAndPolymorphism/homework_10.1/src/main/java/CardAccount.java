public class CardAccount extends BankAccount {

    public void take(double amountToTake) {
        super.take(amountToTake + (amountToTake / 100 * 1));

    }
    
}
