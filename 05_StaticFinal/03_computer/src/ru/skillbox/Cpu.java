public final class Cpu {
    private final int manufacturer;
    private final double weight;
    private final int frequency;
    private final int numberOfCores;

    public Cpu(int frequency, int numberOfCores, int manufacturer, int weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }


    public int getFrequency() {
        return frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public int getManufacturer() {
        return manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return '\n' +
                "    manufacturer = " + manufacturer + '\n' +
                "    weight = " + weight + '\n' +
                "    frequency = " + frequency + '\n' +
                "    numberOfCores = " + numberOfCores ;
    }
}
