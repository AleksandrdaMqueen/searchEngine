import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String myLine = scan.nextLine();


            int end = myLine.indexOf(" ", 0);
            int start = myLine.indexOf(' ', 1);
            int end1 = myLine.length();


            String typeOfOperation = myLine.substring(0, end);
            String todo = myLine.substring(start, end1);
            String regex = "(ADD|DELETE|EDIT|LIST)\\s(0-9)+?\\s(A-z)+";


            if (typeOfOperation.equals(regex)) {

            } else if (typeOfOperation.equals("DELETE")) {
                String num = myLine.substring(end, start);
                int index = Integer.parseInt(num);
                todoList.delete(index);

            }

        }
    }
}

