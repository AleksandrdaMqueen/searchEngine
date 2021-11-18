
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final TreeSet<String> emailList = new TreeSet<>();
        String regex = "(LIST|ADD)\\\\s?(.*)";

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);
                String emailAdress = matcher.group(2).toLowerCase();
                String command = matcher.group(1);
                if (!matcher.matches()) {
                    System.out.println(WRONG_EMAIL_ANSWER);
                    break;
                }
                switch (command){
                    case "ADD":
                        emailList.add(emailAdress);
                    case "LIST":
                        for (String emails : emailList) {
                                System.out.println(emails);
                            }
                    }



            }
        }
    }
}
