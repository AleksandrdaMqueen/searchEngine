package searchengine.model;



import javax.persistence.*;

@Table(name = "Page")

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

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getId() {
        return id;
    }

    public int getCode() {
        return code;
    }
    public int getSiteId() {
        return siteId;
    }

    public String getContent() {
        return content;
    }

    public String getPath() {
        return path;
    }
}
