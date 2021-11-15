import java.util.ArrayList;


public class TodoList {


    final ArrayList<String> whatTodo = new ArrayList<>();


    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списк
        whatTodo.add(todo);
        System.out.println("Добавлено дело: " + todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления


        if (index < 0 || index + 1 > whatTodo.size()) {
            add(todo);

        } else {
            whatTodo.add(index, todo);
            System.out.println("Добавлено дело: " + todo + "На место: " + index);
        }

    }

    public String edit(String todo, int index) {
        if (index >= 0 && index < whatTodo.size()) {
            return whatTodo.set(index, todo);
        }
        return null;
    }

    public String delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index >= 0 && index < whatTodo.size()) {
            return whatTodo.remove(index);
        }
        return null;
    }


    public void list() {
        for (int i = 0; i < whatTodo.size(); i++) {
            System.out.println(i + " - " + whatTodo.get(i));
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return new ArrayList<>(whatTodo);
    }

}


