import javax.persistence.*;

@Entity
@Table(name= "courses")
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

    @Column(name = "students_count")
    int studentsCount;

    int price;
    @Column(name = "price_per_hour")
    float pricePerHour;

    public CourseType getType() {
        return type;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public int getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setTeacherId(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
                " Имя: " + name + " Кол-во студентов: " + studentsCount;

    }
}
