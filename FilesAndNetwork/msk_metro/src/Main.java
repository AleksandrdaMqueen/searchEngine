import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        try {
            Document doc = Jsoup.connect("https://skillbox-java.github.io/").maxBodySize(0).get();

            Elements elements = doc.select("div[data-depend]");
            Elements elements1 = doc.select("div[data-line]");
            Elements elements2 = doc.select("div[data-line]");

            ArrayList<Station> stations = new ArrayList<>();
            ArrayList<Line> lines = new ArrayList<>();
            JSONObject object = new JSONObject();

            for (int i = 0; i < elements1.size() ; i++) {

                stations.add(new Station(elements1.get(i).attr("data-line"),elements2.get(i).text().replaceAll("\\." , "")
                        .replaceAll("2", "")
                        .replaceAll("3", "")
                        .replaceAll("4", "")
                        .replaceAll("5", "")
                        .replaceAll("6", "")
                        .replaceAll("7", "")
                        .replaceAll("8", "")
                        .replaceAll("9", "")
                        .replaceAll("0", "")
                        .replaceAll("1","") ));


                lines.add(new Line(elements.get(i).text() ,elements1.get(i).attr("data-line")));
                JSONArray station =  new JSONArray();
                station.add(elements2.get(i).text().replaceAll("\\." , "") + '\t');
                object.put( elements.get(i).text() ,  station );

            }





            try {
                FileWriter fileWriter = new FileWriter("D:/map2.json");
                fileWriter.write(object.toJSONString());
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                e.printStackTrace();
            }



        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
