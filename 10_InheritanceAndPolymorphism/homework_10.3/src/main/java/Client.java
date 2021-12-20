public abstract class Client {
    protected double totalMoney = 0;
    public double getAmount() {
        return totalMoney;
    }

    public void put(double amountToPut) {
        if (amountToPut < 0){
            System.out.println("Недьзя положить отрицательную сумму");
        }
        else {
            totalMoney += amountToPut;
        }

    }

    public void take(double amountToTake) {
        if(totalMoney > amountToTake || amountToTake < 0){
            totalMoney -= amountToTake;
        }else{
            System.out.println("Недостаточно денег на счету");
        }
    }

}
