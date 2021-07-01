package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(8, 9, 9);
        CargoInfo cargo = new CargoInfo(dimensions, 9, "Pushkinskaya", true, 0, true);
        cargo.setDeliveryAddress("Tallinskaya");
        System.out.println(dimensions);
        dimensions.getVolume();

        System.out.println(cargo);
        System.out.println(dimensions);
    }
}
