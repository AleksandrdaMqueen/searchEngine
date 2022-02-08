import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<String> images = new ArrayList<>();

            String htmFile = parseFile("C:\\Users\\abake\\IdeaProjects\\hw_3\\hw_4\\data\\code.html");

            Document document = Jsoup.parse(htmFile);

            Elements elements = document.select("img");

            elements.forEach(element -> System.out.println(element.absUrl("src")));
            elements.forEach(element -> images.add(element.absUrl("src")));

            for (int i = 0; i < images.size(); i++) {


                InputStream in = new URL(images.get(i)).openStream();
                Files.copy(in, Paths.get("C:\\Users\\abake\\IdeaProjects\\hw_3\\hw_4\\data\\image"+ i + ".jpg"  ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String parseFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> stringBuilder.append(line + '\n'));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return stringBuilder.toString();
    }
}
