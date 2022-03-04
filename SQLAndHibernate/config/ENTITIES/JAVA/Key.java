import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Setter
@Getter
public class Key implements Serializable {

    @Column(name = "student_name", insertable = false,updatable = false)
    private String studentName;

    @Column(name = "course_name",insertable = false,updatable = false)
    private String courseName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return studentName == key.studentName && courseName == key.courseName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, courseName);
    }



}

