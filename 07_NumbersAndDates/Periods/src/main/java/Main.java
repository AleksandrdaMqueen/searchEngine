import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {
  private static LocalDate birthday1 = LocalDate.of(1970, 1, 1);
    private static String text1 = "";
    private static long date = System.currentTimeMillis();
    private  static  LocalDate now = LocalDate.now();
    private  static LocalDate period;
    private static String years = "";
    private static String months = "";
    private static String days = "";
  public static void main(String[] args) {
    System.out.println(getPeriodFromBirthday(birthday1));
  }
  public static String getPeriodFromBirthday(LocalDate birthday1) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        birthday1 = LocalDate.of(1970, 01, 1);

        LocalDate now = LocalDate.now();
        years += birthday1.until(now, ChronoUnit.YEARS);
        months += birthday1.until(now, ChronoUnit.MONTHS) % 12;
        days += birthday1.until(now, ChronoUnit.DAYS);

        System.out.println(years + " years, " + months + " months, " + days + "days");

        return text1;
    }


}
