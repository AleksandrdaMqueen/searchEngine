import java.util.ArrayList;


public class TodoList {


    ArrayList<String> whatTodo = new ArrayList<>();


    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списк
        whatTodo.add(todo);
        System.out.println("Добавлено дело: " + todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления



            if (index < 0 ||  index + 1 > whatTodo.size()) {
                add(todo);

            } else {
                whatTodo.add(index, todo);
                System.out.println("Добавлено дело: " + todo + "На место: " + index);
            }

    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,


            if ( index < 0 || index + 1> whatTodo.size()) {
                System.out.println("Невозможно добавить дело с таким индесом");

            } else {
                whatTodo.remove(index);
                whatTodo.add(index, todo);
                System.out.println("Добавлено дело: " + todo + "На место: " + index);
            }

        //  проверьте возможность изменения
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
            if (index < 0 ||  index + 1 > whatTodo.size()) {
                System.out.println("Невозможно удалить дело с таким индесом");
            } else {
                whatTodo.remove(index);
            }



    }

    public void list(ArrayList<String> whatTodo){
        for (int i = 0; i < whatTodo.size() - 1; i++) {
            for (String item : whatTodo) {
                System.out.println(i +"\\s" + item);
            }
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return  whatTodo ;
    }

}
