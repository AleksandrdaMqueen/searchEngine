import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    calculateSalarySum("Толя заработал 35000 рублей, а Лера - 45000 рублей");
  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    Matcher matcher = Pattern.compile("([0-9]+)").matcher(text);

    while (matcher.find()){
      int num1 =0;
       num1 += Integer.parseInt(matcher.group(1) );
      
       


    }
    return 0;
  }

}
