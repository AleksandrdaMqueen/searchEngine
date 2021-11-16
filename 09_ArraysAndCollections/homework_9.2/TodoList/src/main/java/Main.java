import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final TodoList todoList = new TodoList();
    private static final Pattern p = Pattern.compile("(ADD|LIST|EDIT|DELETE)\\s*([0-9]*)\\s*(.+)*");


    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String myLine = scan.nextLine();


            Matcher m = p.matcher(myLine);
            if (!m.matches()) {
                System.out.println("Некорректный формат команды");
                continue;
            }
            String command = m.group(1);
            int index = !m.group(2).isBlank() ? Integer.parseInt(m.group(2)) : -1;
            String text = m.group(3);
            if (index != -1 && command.equals("ADD")) {
                todoList.add(index, text);
                continue;
            }

            switch (command) {
                case "ADD":
                    todoList.add(text);

                    break;
                case "DELETE":

                    String resultOfMethod = todoList.edit(text, index);
                    if (resultOfMethod != null) {
                        System.out.println("Дело " + resultOfMethod + " удаленно ");
                    } else {
                        System.out.println("Невозможно удалить дело с таким индесом");
                    }

                    break;
                case "EDIT":
                    String result = todoList.edit(text, index);
                    if (result != null) {
                        System.out.println("Дело " + result + " заменено на " + text);
                    } else {
                        System.out.println("Невозможно добавить дело с таким индесом");
                    }
                    break;
                case "LIST":
                    todoList.getTodos();
                    for (int i = 0; i < todoList.getTodos().size(); i++) {
                        System.out.println(i + " - " + todoList.getTodos().get(i));
                    }
            }
        }
    }
}
