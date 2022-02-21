import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student name;

    private int age;
    @Column(name = "registration_date")
    private Date registrationDate;


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Student getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(Student name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
