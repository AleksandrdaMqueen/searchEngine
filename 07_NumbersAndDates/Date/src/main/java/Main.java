import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));


    }


    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        String text = "";
        int count = 0;

        while (today.isAfter(birthday) || today.isEqual(birthday)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E");

            text += count + " - " + formatter.format(birthday) + System.lineSeparator();

            birthday = birthday.plusYears(1);
            count++;

        }
        return text;

//TODO реализуйте метод для построения строки в следующем виде
//0 - 31.12.1990 - Mon
//1 - 31.12.1991 - Tue

    }

}
