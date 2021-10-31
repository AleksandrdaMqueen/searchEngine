import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String myLine = scan.nextLine();


        int end = myLine.indexOf(" ", 0);

        String typeOfOperation = myLine.substring(0, end);

        int start = myLine.indexOf(' ', 1);

        int end1 = myLine.length();

        String todo = myLine.substring(start, end1);

        if (typeOfOperation == "ADD") {
            todoList.add(todo);
            todoList.getTodos();
        }


    }
}

