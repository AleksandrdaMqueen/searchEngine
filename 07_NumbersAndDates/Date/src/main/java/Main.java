import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {
    private static LocalDate birthday1 = LocalDate.of(1970, 1, 1);
    private static String text1 = "";
    private static long date = System.currentTimeMillis();

    public static void main(String[] args) {
        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
        System.out.println(getPeriodFromBirthday(birthday1));

    }


    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        String text = "";
        int count = 0;

        while (today.isAfter(birthday) || today.isEqual(birthday)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E").localizedBy(Locale.US);

            text += count + " - " + formatter.format(birthday) + System.lineSeparator();

            birthday = birthday.plusYears(1);
            count++;

        }
        return text;
    }
//TODO реализуйте метод для построения строки в следующем виде
//0 - 31.12.1990 - Mon2233444444444422222222222222222222222222222222222222222222222222222288888888844444444422222222222222222222222222222222222288888888888888888
//1 - 31.12.1991 - Tue

    public static String getPeriodFromBirthday(LocalDate birthday) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        birthday1 = LocalDate.of(1970,01,1);
        String text1 = "";
        LocalDate now = LocalDate.now();
        formatter.format(birthday1);
        formatter.format(now);
        text1 += birthday1.until(now,ChronoUnit.YEARS);

        return text1;
    }


}
