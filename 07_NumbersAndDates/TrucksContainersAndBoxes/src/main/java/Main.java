import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int limitOfBoxesForOneContainer = 27;
        int container = 1;
        int maxContainersInCargo = 12;
        int cargo = 1;
        int v = 0;
        int c = 0;
        int i = 0;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число ящиков: ");
        int boxes = Integer.parseInt(scanner.nextLine());
        if (boxes == 0) {
            System.out.println("Недостаточно ящиков для перевозки");
        } else {
            while (boxes >= 28) {
                if (boxes / limitOfBoxesForOneContainer > 0) {
                    container = boxes / limitOfBoxesForOneContainer;
                    container++;
                    break;
                }
            }
            while (container >= 13) {
                if (container / maxContainersInCargo > 0) {
                    cargo = boxes / maxContainersInCargo;
                    cargo++;
                    break;
                }
            }
            for (i = 1; i <= cargo; i++) {
                System.out.println("Грузовик: " + i);
                for (c = 1; c <= container; c++) {
                    System.out.println("\tКонтейнер: " + c + '\t');
                    for (v = 1; v <= boxes; v++) {
                        System.out.println( "\t\tЯщик: " + v);

                    }

                }
            }
            System.out.println("Необходимо:" + '\n' + "грузовиков - " + cargo + " шт." + '\n' + "контейнеров - " + container + " шт.");
        }

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
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
