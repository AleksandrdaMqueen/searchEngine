import java.util.ArrayList;

public class TodoList {
        ArrayList<String> whatTodo = new ArrayList<>();
    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списк
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        for (int i = 0; i < whatTodo.size(); i++) {
            if(index > i || index < 0){
                System.out.println("Невозможно удалить дело с таким индесом");
                break;
            }else {
                whatTodo.remove(index);
            }

        }
        
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return new ArrayList<>();
    }

}
