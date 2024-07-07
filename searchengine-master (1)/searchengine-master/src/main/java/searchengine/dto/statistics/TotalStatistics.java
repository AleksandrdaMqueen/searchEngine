package searchengine.dto.statistics;




public class TotalStatistics {
    private int sites;
    private int pages;
    private int lemmas;
    private boolean indexing;

    public void setSites(int sites) {
        this.sites = sites;
    }

    public int getLemmas() {
        return lemmas;
    }

    public int getPages() {
        return pages;
    }

    public int getSites() {
        return sites;
    }

    public void setIndexing(boolean indexing) {
        this.indexing = indexing;
    }

    public void setLemmas(int lemmas) {
        this.lemmas = lemmas;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
