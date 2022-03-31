package Main;

import Main.Model.Todo;
import Main.Model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    public TodoController(TodoRepository repository){
        this.todoRepository = repository;
    }

    @GetMapping("/todos")
    public List<Todo> list(){
        Iterable<Todo> todoIterable = todoRepository.findAll();
        ArrayList<Todo> arrayList = new ArrayList<>();
        for(Todo todo : todoIterable){
            arrayList.add(todo);
        }
        return arrayList;
    }

    @PostMapping("/todo/add")
    public RedirectView add(@RequestParam String name) {
        Todo todo = new Todo(name);
        todoRepository.save(todo);
        return new RedirectView("/");
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Todo> optionalBook = todoRepository.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
    }


    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    public void deleteTodo(int id){
        todoRepository.deleteById(id);
    }


    @RequestMapping(value = "/todo/", method = RequestMethod.DELETE)
    public void deleteAllTodos(){
        todoRepository.deleteAll();
    }


    @RequestMapping(value = "/todo/{id}",method = RequestMethod.PATCH)
    public void editTodo(int id, String newName){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        Todo todoToEdit = optionalTodo.get();
        todoToEdit.setName(newName);
        todoRepository.save(todoToEdit);
    }

}
