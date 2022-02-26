import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "courses")
@Setter
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    String name;

    int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    CourseType type;

     String description;
    @ManyToOne(cascade = CascadeType.ALL)
    Teacher teacher;

    @Column(name = "students_count", nullable = true)
    int studentsCount;

    int price;
    @Column(name = "price_per_hour")
    float pricePerHour;



    @Override
    public String toString() {
        return
                " Имя: " + name + " Кол-во студентов: " + studentsCount;

    }
}

