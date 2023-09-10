package searchengine.model;

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

    @Column(name = "code", columnDefinition = "MEDIUMTEXT")
    private int code;

    @Column(name = "site_id", columnDefinition = "MEDIUMTEXT")
    private int siteId;

    @Column(name = "content",columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name = "path",columnDefinition = "MEDIUMTEXT")
    private String path;
}
