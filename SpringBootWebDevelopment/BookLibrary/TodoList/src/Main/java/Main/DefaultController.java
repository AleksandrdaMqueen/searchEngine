package Main;


import Main.Model.Todo;
import Main.Model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class DefaultCobtroller {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<Todo> todoIterable = todoRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>();
        int todosCount = 0;
        for(Todo todo : todoIterable){
            todosCount++;
            todos.add(todo);
        }
        model.addAttribute("todos", todos);
        model.addAttribute("todosCount", todosCount);
        return "index";
    }
}
