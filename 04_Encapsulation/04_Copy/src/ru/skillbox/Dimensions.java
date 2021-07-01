public class Dimensions {
    private final int height;
    private final int width;
    private final int length;
    private final int volume;


    public Dimensions(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.volume = length * height * width;

    }

    public Dimensions setHeight(int height) {
        return new Dimensions(height, width, length);
    }

    public Dimensions setLength(int length) {
        return new Dimensions(height, width, length);
    }

    public Dimensions setWidth(int width) {
        return new Dimensions(height, width, length);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Dimensions" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", volume=" + volume 
                ;
    }
}