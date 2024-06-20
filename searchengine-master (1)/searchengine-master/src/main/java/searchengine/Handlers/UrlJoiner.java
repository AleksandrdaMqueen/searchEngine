package searchengine.Handlers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.RecursiveTask;

public class UrlJoiner extends RecursiveTask<String> {
    String url;

    public UrlJoiner(String url) {



        this.url = url;
    }

    @Override
    protected String compute() {
        StringBuilder list = new StringBuilder();
        Document doc = null;
        try {
            doc = Jsoup.connect(url).maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = doc.select("a[href]");
        for (Element element : elements) {

            String urlToScan = element.attr("abs:href");
            list.append('\t').append(urlToScan).append('\n');

        }

        return list.toString();
    }
}
