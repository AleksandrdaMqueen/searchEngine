package searchengine.dto.statistics;

import lombok.Data;

@Data
public class DetailedStatisticsItem {
    private String url;
    private String name;
    private String status;
    private long statusTime;
    private String error;
    private long pages;
    private int lemmas;

    public int getLemmas() {
        return lemmas;
    }

    public long getPages() {
        return pages;
    }

    public long getStatusTime() {
        return statusTime;
    }

    public String getError() {
        return error;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }

    public void setLemmas(int lemmas) {
        this.lemmas = lemmas;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusTime(long statusTime) {
        this.statusTime = statusTime;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
