package searchengine.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "indexx")
@Entity
@Data
@NoArgsConstructor
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "page_id")
    int page_id;

    @Column(name = "lemma_id")
    int lemma_id;

    @Column(name = "ranc")
    float rankc;

    
}
