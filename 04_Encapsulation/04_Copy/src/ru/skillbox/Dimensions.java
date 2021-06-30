public class Dimensions {
    private final int height;
    private final int width;
    private final int lenght;
    private final int volume;


    public Dimensions(int height, int width, int lenght, int volume) {
        this.height = height;
        this.width = width;
        this.lenght = lenght;
        this.volume = lenght * height * width;

    }

    public Dimensions setHeight(int height) {
        return new Dimensions(height, width, lenght, volume);
    }

    public Dimensions setLenght(int lenght) {
        return new Dimensions(height, width, lenght, volume);
    }

    public Dimensions setVolume(int volume) {
        return new Dimensions(height, width, lenght, volume);
    }

    public Dimensions setWidth(int width) {
        return new Dimensions(height, width, lenght, volume);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLenght() {
        return lenght;
    }

    public int getVolume() {
        return volume;
    }
}