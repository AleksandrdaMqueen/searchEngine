package Main.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public Todo(String name){
        this.name = name;
    }

}
