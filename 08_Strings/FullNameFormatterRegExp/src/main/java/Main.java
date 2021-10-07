import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            String letterList = "[А-я]+";
            String regex =  letterList + "-?" + letterList + "[\\s]" + letterList + "[\\s]" + letterList;
            if (!input.matches(regex)) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }

            String[] formatter = input.split("\\s");
            System.out.println("Фамилия: " + formatter[0]);
            System.out.println("Имя: " + formatter[1]);
            System.out.println("Отчество: " + formatter[2]);


            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
        }
    }

}
