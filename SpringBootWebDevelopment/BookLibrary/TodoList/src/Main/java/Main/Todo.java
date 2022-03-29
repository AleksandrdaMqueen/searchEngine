package Main.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Todo {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public Todo(String name, int id){
        this.id = id;
        this.name = name;
    }

}
