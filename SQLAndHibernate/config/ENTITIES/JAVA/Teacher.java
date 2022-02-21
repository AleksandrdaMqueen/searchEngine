import javax.persistence.*;

@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private Teacher name;

    private int salary;


    private int age;

    public int getId() {
        return id;
    }

    public void setName(Teacher name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}

