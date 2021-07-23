import java.time.LocalDate;

public class Main {

  public static void main(String[] args) {
    System.out.println(getPeriodFromBirthday(birthday1));
  }
  public static String getPeriodFromBirthday(LocalDate birthday1) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        birthday1 = LocalDate.of(1970,01,1);

        LocalDate now = LocalDate.now();
        years += birthday1.until(now, ChronoUnit.YEARS) ;
        months += birthday1.until(now,ChronoUnit.MONTHS) / 12 / 30;
        days += birthday1.until(now, ChronoUnit.DAYS) /( 24 * 60);

        System.out.println(years + " years, " + months + " months, " + days + "days");

        return text1;
    }


}
