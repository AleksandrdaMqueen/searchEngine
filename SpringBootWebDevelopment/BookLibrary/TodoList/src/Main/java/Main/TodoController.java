package Main;

import Main.Model.Todo;
import Main.Model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;


    @RequestMapping(value = "/todos/",method = RequestMethod.GET)
    public List<Todo> list(){
        Iterable<Todo> todoIterable = todoRepository.findAll();
        ArrayList<Todo> arrayList = new ArrayList<>();
        for(Todo todo : todoIterable){
            arrayList.add(todo);
        }
        return arrayList;
    }

    
    @RequestMapping(value =  "/todos/",method = RequestMethod.POST)
    public int add(Todo todo){
        Todo todo1 = todoRepository.save(todo);
        return todo1.getId();
    }


    @GetMapping("/todos/{id}")
    public ResponseEntity get(@PathVariable int id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(!optionalTodo.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTodo.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/todos/", method = RequestMethod.DELETE)
    public void deleteTodo(int id){
        todoRepository.deleteById(id);
    }


    @RequestMapping(value = "/todos/", method = RequestMethod.DELETE)
    public void deleteAllTodos(){
        todoRepository.deleteAll();
    }


    @RequestMapping(value = "/todos/{id}",method = RequestMethod.PATCH)
    public void editTodo(int id, String newName){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        Todo todoToEdit = optionalTodo.get();
        todoToEdit.setName(newName);
        todoRepository.save(todoToEdit);
    }

}
