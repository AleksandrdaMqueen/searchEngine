public class CargoInfo {
    private final int dimensions;
    private final int weight;
    private final String deliveryAdress;
    private final boolean canBeTurnedOver;
    private final int registratioNumber;
    private final boolean whetherTheCargoIsFragile;

    public CargoInfo(int dimensions, int weight, String deliveryAddress, boolean canBeTurnedOver, int registratioNumber, boolean whetherTheCargoIsFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAdress = deliveryAddress;
        this.canBeTurnedOver = canBeTurnedOver;
        this.registratioNumber = registratioNumber;
        this.whetherTheCargoIsFragile = whetherTheCargoIsFragile;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAdress;
    }

    public boolean isCanBeTurnedOver() {
        return canBeTurnedOver;
    }

    public int getRegistratioNumber() {
        return registratioNumber;
    }

    public boolean isWhetherTheCargoIsFragile() {
        return whetherTheCargoIsFragile;
    }

    public int getDimensions() {
        return dimensions;
    }

    public CargoInfo setDeliveryAdress(String deliveryAdress) {
        return new CargoInfo(dimensions, weight, deliveryAdress, canBeTurnedOver, registratioNumber, whetherTheCargoIsFragile);
    }

    public CargoInfo setDimensions(int dimensions) {
        return new CargoInfo(dimensions, weight, deliveryAdress, canBeTurnedOver, registratioNumber, whetherTheCargoIsFragile);
    }


}
