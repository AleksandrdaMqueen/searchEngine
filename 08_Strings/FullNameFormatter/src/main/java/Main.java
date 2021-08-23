import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String space = " ";
            int pos = 0;

            int checkSpace = input.indexOf(space);
            int i = 0;
            char num = input.charAt(i);

            while (Character.isDigit(num)) {
                i++;
                if (Character.isDigit(num)) {
                    System.out.println("Введенная строка не является ФИО");
                }

                break;
            }
            if (input.equals("0")) {
                break;
            }
            if (input.isBlank()) {
                System.out.println("Введенная строка не является ФИО");

                break;
            }
            if (checkSpace == -1) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }if(!Character.isDigit(num))
                while (true) {
                    i++;
                    if (Character.isDigit(num)) {
                        System.out.println("Введенная строка не является ФИО");
                    }

                break;



            }
            else {
                int start = input.indexOf(' ', pos);
                String lastname = "Фамилия: ".concat(input.substring(0, start));
                System.out.println(lastname);
                int c = input.substring(0,start).length();
                int start2 = input.indexOf(' ', c + 1);
                String name = "Имя:".concat( input.substring(c, start2));
                System.out.println(name);
                int a = c + input.substring(c, start2).length();
                int start3 = input.indexOf(' ' , a);
                String patronymic = "Отчество: ".concat(input.substring(a ,start3));
                System.out.println(patronymic);


            }


        }
    }
