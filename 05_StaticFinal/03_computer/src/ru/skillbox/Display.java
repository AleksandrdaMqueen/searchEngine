public class Display {
    public Display getDiagonal() {
        return diagonal;
    }

    public Display getType() {
        return type;
    }

    public  Display getWeight() {
        return weight;
    }

    private  final Display diagonal;
    private final Display type;
    private final  Display weight;

    public Display(Display diagonal, Display type, Display weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }
}
