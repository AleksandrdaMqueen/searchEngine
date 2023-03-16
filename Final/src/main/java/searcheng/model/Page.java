package searcheng.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Page")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int siteId;

    private String path;
}
