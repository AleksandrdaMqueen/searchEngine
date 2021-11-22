import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private  static  final String regex = "(LIST|ADD)\\s([A-z]+@[A-z]+\\.[a-z]+)";
    private static final Pattern pattern = Pattern.compile(regex);
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
        TreeSet<String> emailList = new TreeSet<>();
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        while (true) {
            if (input.equals("0")) {
                break;
            } else {
                if (!matcher.matches()) {
                    System.out.println(WRONG_EMAIL_ANSWER);
                    break;
                } else {

                    String emailAdress = matcher.group(2).toLowerCase();
                    String command = matcher.group(1);


                    if (command.equals("ADD")) {
                        if (emailList.contains(emailAdress.toLowerCase(Locale.ROOT))) {
                            System.out.println("Такой email уже существует");
                            break;
                        } else {
                            emailList.add(emailAdress);
                            System.out.println("Добавлен email " + emailAdress);

                        }
                    } else if (command.equals("LIST")) {
                        for (String emails : emailList) {
                            System.out.println(emails);
                        }
                    }
                }
            }
        }
    }
}

