package searcheng.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "Site")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated
    private Status status;


    private LocalDate status_time;

    private String lastError;

    private String url;

    private String name;



}
