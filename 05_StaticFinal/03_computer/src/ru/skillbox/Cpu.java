public final class Cpu {
    private final Cpu manufacturer;
    private final Cpu weight;
    private final Cpu frequency;
    private final Cpu numberOfCores;

    public Cpu(Cpu frequency, Cpu numberOfCores, Cpu manufacturer, Cpu weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }


    public Cpu getFrequency() {
        return frequency;
    }

    public Cpu getNumberOfCores() {
        return numberOfCores;
    }

    public Cpu getManufacturer() {
        return manufacturer;
    }

    public Cpu getWeight() {
        return weight;
    }


}
