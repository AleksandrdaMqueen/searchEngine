package searchengine.dto.statistics;




public class StatisticsResponse {
    private boolean result;
    private StatisticsData statistics;

    public void setResult(boolean result) {
        this.result = result;
    }

    public StatisticsData getStatistics() {
        return statistics;
    }

    public void setStatistics(StatisticsData statistics) {
        this.statistics = statistics;
    }

}
