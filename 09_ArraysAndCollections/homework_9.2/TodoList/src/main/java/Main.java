import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String myLine = scan.nextLine();


            String regex = "(ADD|DELETE|EDIT|LIST)\\s?([0-9]+)?\\s?([A-z]+)?";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(myLine);
            if (!matcher.matches()) {
                System.out.println("Incorrect expression");
            }
            System.out.println("Command: " + matcher.group(1) + " Index: " + matcher.group(2) + " Text: " + matcher.group(3));
        }
    }
}
