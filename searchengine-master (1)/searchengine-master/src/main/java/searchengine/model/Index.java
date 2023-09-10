package searchengine.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Index")
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int page_id;

    int lemma_id;

    float rank;

    
}
