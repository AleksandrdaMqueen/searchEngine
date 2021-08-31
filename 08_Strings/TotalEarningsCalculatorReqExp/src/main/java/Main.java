import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    calculateSalarySum("Толя заработал 35000 рублей, а Лера - 45000 рублей");
  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод

    String regex ="[^А-Я][0-9]";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()){
      int start = matcher.start();
      int end = matcher.end();

      String num =text.substring(start  ,end );
      System.out.print(num);
      int endSpace =num.indexOf(' ',1);
      String firstNum = num.substring(1,endSpace);

    }

    return -1;
  }

}
