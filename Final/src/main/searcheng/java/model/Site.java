package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "Site")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private Status status;


    private Date status_time;

    private String lastError;

    private String url;

    private String name;



}
