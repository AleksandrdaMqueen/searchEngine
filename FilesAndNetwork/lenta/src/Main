import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> images = new ArrayList<>();

        String htmFile = parseFile("C:\\Users\\abake\\IdeaProjects\\hw_3\\hw_4\\data\\code.html");

        Document document = Jsoup.parse(htmFile);

        Elements elements = document.select("img");

        elements.forEach(element -> System.out.println(element.absUrl("src")));
        elements.forEach(element -> images.add(element.absUrl("src")));
        try {
            Files.write(Paths.get("C:\\Users\\abake\\IdeaProjects\\hw_3\\hw_4\\data\\images.txt"), images);
        }catch (Exception e){
            e.printStackTrace();
        }

        String command = scanner.nextLine();



    }

    public static String parseFile(String path){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> stringBuilder.append(line + '\n'));
        }catch (Exception e){
            e.printStackTrace();
        }




        return stringBuilder.toString();
    }
}
