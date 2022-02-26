import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "subscriptions")
@Entity
@Getter
@Setter
public class Subscription {
    @EmbeddedId
    private Key id;

    @Column(name = "student_id", insertable = false,updatable = false )
    private int studentId;
    @Column(name = "course_id", insertable = false,updatable = false )

    private int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;


}
