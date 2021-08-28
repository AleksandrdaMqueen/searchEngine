import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int pos = 0;
        int i = 0;

        while (i < input.length()) {
            i++;
            char ch = input.charAt(i);


            if (ch == ' ') {
                pos++;
                if (pos < 2) {
                    System.out.println("Введенная строка не является ФИО");
                    break;
                }
            }
            if (!Character.UnicodeBlock.of(ch).equals(Character.UnicodeBlock.CYRILLIC)) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }

        }
    }
}
