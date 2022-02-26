import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Setter
@Getter
@Table(name = "LinkedPurchaseList")

public class LinkedPurchaseList {
    @EmbeddedId

    private Key id;
    @Column(name = "student_id", insertable = false, updatable = false,nullable = true)

    private Integer studentId;

    @Column(name = "course_id", insertable = false, updatable = false,nullable = true)

    private Integer courseId;


}
