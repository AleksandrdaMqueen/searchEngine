import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailList {
    private final TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {
        String regex = "([A-z]+@[A-z]+\\.[a-z]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            System.out.println("Неверный формат email");
        } else if (emailList.contains(email.toLowerCase(Locale.ROOT))) {
            System.out.println("Такой email уже существует");
        } else {
            emailList.add(email);
            System.out.println("Добавлен email " + email);
        }
    }


    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        return new ArrayList<>(emailList);
    }

}
