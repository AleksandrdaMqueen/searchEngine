package searchengine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Lemma")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Lemma {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "site_id", columnDefinition = "int")
    int site_id;

    @Column(name = "lemma", columnDefinition = "VARCHAR(255)")
    String lemma;

    @Column(name = "frequency", columnDefinition = "MEDIUMTEXT")
    int frequency;
}
