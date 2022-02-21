import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "purchaselist")
public class PurcaseList
{
    @Column(name = "student_name")
    private String studentName;

    private String courseName;

    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
