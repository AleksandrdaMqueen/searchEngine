package Main;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {

    private String name;
    private int id;
    public Todo(String name, int id){
        this.id = id;
        this.name = name;
    }

}
