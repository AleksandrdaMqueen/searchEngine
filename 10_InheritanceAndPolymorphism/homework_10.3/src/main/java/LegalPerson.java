public class LegalPerson extends Client {
    public void take(double amountToTake) {
        super.take(amountToTake + amountToTake * 1 / 100);
    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
    }
}
