package searchengine.model;



import lombok.Data;

import javax.persistence.*;

@Table(name = "indexx")
@Entity
@Data
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

    public void setId(int id) {
        this.id = id;
    }

    public void setLemma_id(int lemma_id) {
        this.lemma_id = lemma_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }

    public void setRankc(float rankc) {
        this.rankc = rankc;
    }

    public int getId() {
        return id;
    }

    public float getRankc() {
        return rankc;
    }


    public int getLemma_id() {
        return lemma_id;
    }

    public int getPage_id() {
        return page_id;
    }

}
