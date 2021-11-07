import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String myLine = scan.nextLine();


            int end = myLine.indexOf(" ", 0);

            int end1 = myLine.length();
            int start = myLine.indexOf(' ', end);
            int length = myLine.length();

            String typeOfOperation = myLine.substring(0, end);
            String regex = "(ADD|DELETE|EDIT|LIST)\\s(0-9)+\\s(A-z)+";
            String num = myLine.substring(end, start);



            if (typeOfOperation.matches(regex)) {
                String todoWithIndex = myLine.substring(start, end1);
                int index = Integer.parseInt(num);
                switch (typeOfOperation) {
                    case "ADD":
                        todoList.add(index, todoWithIndex);
                        break;
                    case "DELETE":
                        todoList.delete(index);
                        break;
                    case "EDIT":
                        todoList.edit(todoWithIndex, index);
                        break;
                }
            }
            else if(!typeOfOperation.matches(regex)){
                String todoWithoutIndex = myLine.substring(end, length);
                if ("ADD".equals(typeOfOperation)) {
                    todoList.add(todoWithoutIndex);
                }

            }

        }
    }
}
