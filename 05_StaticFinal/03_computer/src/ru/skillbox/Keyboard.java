public class Keyboard {
    private  final  Keyboard type;
    private  final Keyboard isRGB;
    private  final  Keyboard weight;

    public Keyboard getType() {
        return type;
    }

    public Keyboard getIsRGB() {
        return isRGB;
    }

    public  Keyboard getWeight() {
        return weight;
    }

    public Keyboard(Keyboard type, Keyboard isRGB, Keyboard weight) {
        this.type = type;
        this.isRGB = isRGB;
        this.weight = weight;
    }
}
