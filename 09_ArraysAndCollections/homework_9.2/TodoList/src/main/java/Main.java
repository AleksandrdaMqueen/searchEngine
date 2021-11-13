import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final TodoList todoList = new TodoList();

    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String myLine = scan.nextLine();

            Pattern p = Pattern.compile("(ADD|LIST|EDIT|DELETE)\\s*([0-9]*)\\s*(.+)*");
            Matcher m = p.matcher(myLine);
            if (!m.matches()) {
                System.out.println("Некорректный формат команды");
                continue;
            }
            String command = m.group(1);
            int index = !m.group(2).isBlank() ? Integer.parseInt(m.group(2)) : -1;
            String text = m.group(3);
            if(index != -1 && command.equals("ADD")){
                todoList.add(index,text);
                continue;
            }

            switch (command) {
                case "ADD":
                    todoList.add(text);

                    break;
                case "DELETE":
                    todoList.delete(index);
                    break;
                case "EDIT":
                    todoList.edit(text, index);
                    System.out.println("Отредактировано  дело: " + text );
                    break;
                case "LIST":
                    todoList.list();
            }
        }
    }
}
