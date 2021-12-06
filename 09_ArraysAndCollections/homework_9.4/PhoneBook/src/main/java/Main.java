import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String regex4name = "([А-я]+)";
    private static final String regex4phone = "([0-9]{10,11})";

    private static final Pattern pattern4name = Pattern.compile(regex4name);
    private static final Pattern pattern4phone = Pattern.compile(regex4phone);

    public static final HashMap<String, String> phones = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            Matcher matcher4name = pattern4name.matcher(input);
            Matcher matcher4phone = pattern4phone.matcher(input);


            if (matcher4name.matches() && !phones.containsValue(input)) {
                System.out.println("Введите номер телефона для абонента " + input + ": ");
                String phone = scanner.nextLine();
                if (!phone.matches(regex4phone)) {
                    System.out.println("Некорректный номер");
                } else {
                    phones.put(input, phone);
                    System.out.println("Контакт " + input + " с номером " + phone + " записан!");
                }
            } else if (matcher4phone.matches() && !phones.containsKey(input)) {
                System.out.println("Введите имя для телефона " + input);
                String name = scanner.nextLine();
                if(!name.matches(regex4name)){
                    System.out.println("Некорректное имя");
                }
                phones.put(input, name);
                System.out.println("Контакт " + name + " с номером " + input + " записан!");
            } else if (input.equals("LIST")) {
                System.out.println(phones);
            } else {
                System.out.println("Некорректный ввод ");
            }
        }

    }
}
