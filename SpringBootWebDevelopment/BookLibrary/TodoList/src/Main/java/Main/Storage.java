package Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private static HashMap<Integer,Todo> todos = new HashMap<Integer, Todo>();
    
    

    public  static ArrayList<Todo> getTodos() {
        ArrayList<Todo> todosList = new ArrayList<>();
        todosList.addAll(todos.values());
        return todosList;
    }
    public static Todo getTodo(int id ){
        if (todos.containsKey(id)){
            return todos.get(id);
        }
        return null;
    }



    public static Todo addTodo(String name){
        Todo todo = new Todo(name,todos.size());
        todos.put(todo.getId(), todo);
        return todo;
    }

    public  static void deleteTodo(int id){
        todos.remove(id);
    }
}
