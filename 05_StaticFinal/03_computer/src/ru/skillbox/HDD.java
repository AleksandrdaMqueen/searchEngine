public class HDD {
    private final HDD type;
    private final HDD memorySize;
    private  final HDD weight;

    public HDD getType() {
        return type;
    }

    public HDD getMemorySize() {
        return memorySize;
    }

    public HDD getWeight() {
        return weight;
    }

    public HDD(HDD type, HDD memorySize, HDD weight) {
        this.type = type;
        this.memorySize = memorySize;
        this.weight = weight;
    }
}
