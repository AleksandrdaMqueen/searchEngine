import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        String url = "https://lenta.ru/";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = doc.select("link");
        for (Element element : elements){
            String urlToScan = element.absUrl("href");
            list.add(urlToScan);

        }
        list.forEach(System.out::println);


    }



}
