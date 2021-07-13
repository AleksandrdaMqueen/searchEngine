public class Keyboard {
    private  final  KeyboardType type;
    private  final boolean isRGB;
    public   final  double weight;

    public KeyboardType getType() {
        return type;
    }

    public boolean getIsRGB() {
        return isRGB;
    }

    public  double getWeight() {
        return weight;
    }

    public Keyboard(KeyboardType type, boolean isRGB, double weight) {
        this.type = type;
        this.isRGB = isRGB;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return '\n' +
                "    type = " + type + '\n' +
                "    isRGB = " + isRGB + '\n' +
                "    weight = " + weight ;
    }
}
