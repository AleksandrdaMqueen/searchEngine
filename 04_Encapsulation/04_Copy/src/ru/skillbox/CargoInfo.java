public class CargoInfo {
    private final Dimensions dimensions;
    private final int weight;
    private final String deliveryAddress;
    private final boolean canBeTurnedOver;
    private final int registrationNumber;
    private final boolean whetherTheCargoIsFragile;

    public CargoInfo(Dimensions dimensions, int weight, String deliveryAddress, boolean canBeTurnedOver, int registrationNumber, boolean whetherTheCargoIsFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.canBeTurnedOver = canBeTurnedOver;
        this.registrationNumber = registrationNumber;
        this.whetherTheCargoIsFragile = whetherTheCargoIsFragile;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isCanBeTurnedOver() {
        return canBeTurnedOver;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isWhetherTheCargoIsFragile() {
        return whetherTheCargoIsFragile;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public CargoInfo setDeliveryAddress(String deliveryAddress) {
        return new CargoInfo(dimensions, weight, deliveryAddress, canBeTurnedOver, registrationNumber, whetherTheCargoIsFragile);
    }

    public CargoInfo setDimensions(Dimensions dimensions) {
        return new CargoInfo(dimensions, weight, deliveryAddress, canBeTurnedOver, registrationNumber, whetherTheCargoIsFragile);
    }

    @Override
    public String toString() {
        return "CargoInfo" +
                "dimensions = " + dimensions + '\n' +
                " weight = " + weight + '\n' +
                " deliveryAddress = '" + deliveryAddress + '\'' + '\n' +
                " canBeTurnedOver = " + canBeTurnedOver + '\n' +
                " registrationNumber = " + registrationNumber + '\n' +
                " whetherTheCargoIsFragile = " + whetherTheCargoIsFragile;
    }
}

