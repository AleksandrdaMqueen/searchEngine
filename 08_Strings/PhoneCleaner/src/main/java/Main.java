import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }


            final String numberList1 = "[^0-9]";
            final String numberList = "[0-9]{10,11}";
            final String replacer = input.replaceAll(numberList1, "");
            char ch = replacer.charAt(0);


            if (!replacer.matches(numberList)) {
                System.out.println("Неверный формат номера");
            } else if (replacer.length() == 10) {
                System.out.println("7" + replacer);
            } else if (replacer.charAt(0) == '8' && replacer.length() == 11) {
                System.out.println(replacer.replaceFirst(String.valueOf(ch), "7"));
            } else if (replacer.length() == 11 && ch == '9') {
                System.out.println("Неверный формат номера");
            } else {
                System.out.println(replacer);
            }


            //TODO:напишите ваш код тут, результат вывести в консоль.
        }
    }

}
