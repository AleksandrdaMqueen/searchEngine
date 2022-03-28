package Main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    @RequestMapping(value = "/todos/",method = RequestMethod.GET)
    public List<Todo> list(){
        return Storage.getTodos();
    }

    @RequestMapping(value =  "/todos/",method = RequestMethod.POST)
    public Todo add(String name){
        return Storage.addTodo(name);
    }

    @GetMapping("/todos/{id}")
    public Todo get(int id){
        Todo todo =   Storage.getTodo(id);
        return todo;
    }
    @RequestMapping(value = "todos", method = RequestMethod.DELETE)
    public void deleteTodo(int id){
        Storage.deleteTodo(id);
    }

}
