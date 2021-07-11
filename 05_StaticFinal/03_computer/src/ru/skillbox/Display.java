public class Display {
    public int getDiagonal() {
        return diagonal;
    }

    public DisplayType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    private  final int diagonal;
    private final DisplayType type;
    private final  double weight;

    public Display(int diagonal, DisplayType type, int weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight =weight;
    }
}
