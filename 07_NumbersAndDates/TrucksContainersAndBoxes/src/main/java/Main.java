import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int limitOfBoxesForOneContainer = 28;
        int container = 1;
        int maxContainersInCargo = 12;
        int cargo = 1;
        int v = 0;
        int i = 0;


        Scanner scanner = new Scanner(System.in);
        int boxes = Integer.parseInt(scanner.nextLine());
        if (boxes == 0) {
            System.out.println("Необходимо:" + '\n' + "грузовиков - " + 0 + " шт." + '\n' + "контейнеров - " + 0 + " шт.");
        }else {
            System.out.println("Грузовик: " + cargo);
            System.out.println("\tКонтейнер: " + container);

            for (i = 1; i <= boxes; i++) {
                if (i % (maxContainersInCargo * limitOfBoxesForOneContainer) == 0) {
                    cargo += 1;
                    System.out.println("Грузовик: " + cargo);
                }else if(container > maxContainersInCargo){
                    cargo++;
                    System.out.println("Грузовик: " + cargo);
                }
                if (i % limitOfBoxesForOneContainer == 0) {
                    container += 1;
                    System.out.println("\tКонтейнер: " + container);
                }
                System.out.println("\t\tЯщик: " + i);
            }
            System.out.println("Необходимо:" + '\n' + "грузовиков - " + cargo + " шт." + '\n' + "контейнеров - " + container + " шт.");
            // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
            // пример вывода при вводе 2
            // для отступа используйте табуляцию - \t

        /*            System.out.println("Необходимо:" + '\n' + "грузовиков - " + cargo + " шт." + '\n' + "контейнеров - " + container + " шт.");

        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */

        }

    }
}
