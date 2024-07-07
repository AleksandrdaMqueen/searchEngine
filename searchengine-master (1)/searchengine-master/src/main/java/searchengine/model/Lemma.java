package searchengine.model;



import javax.persistence.*;

@Table(name = "Lemma")

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

    public void setId(int id) {
        this.id = id;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public int getId() {
        return id;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getSite_id() {
        return site_id;
    }

    public String getLemma() {
        return lemma;
    }
}
