public class HDD {
    private final HDDtype type;
    private final int memorySize;
    private  final double weight;

    public HDDtype getType() {
        return type;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public double getWeight() {
        return weight;
    }

    public HDD(HDDtype type, int memorySize, int weight) {
        this.type = type;
        this.memorySize = memorySize;
        this.weight = weight;
    }
}
