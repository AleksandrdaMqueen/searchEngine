import javax.persistence.*;
import java.util.Date;

@Table
@Entity
public class Subscription {

    @EmbeddedId
    private  Key id;
    @Column(name = "student_id", insertable = false,unique = false)
    private int studentsId;
    @Column(name = "course_id", insertable = false,unique = false)
    private int courseId;

    private Date subscriptionDate;

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public int getCourseId() {
        return courseId;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public int getStudentsId() {
        return studentsId;
    }

    public Key getId() {
        return id;
    }

    public void setStudentsId(int studentsId) {
        this.studentsId = studentsId;
    }
}
