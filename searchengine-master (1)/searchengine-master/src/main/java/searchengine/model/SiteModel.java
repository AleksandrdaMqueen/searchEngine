package searchengine.model;



import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "Site")

@Entity
public class SiteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated
    private Status status;


    private LocalDate status_time;

    private String lastError;

    private String url;

    private String name;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStatus_time() {
        return status_time;
    }

    public Status getStatus() {
        return status;
    }

    public String getLastError() {
        return lastError;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public void setStatus_time(LocalDate status_time) {
        this.status_time = status_time;
    }
}
