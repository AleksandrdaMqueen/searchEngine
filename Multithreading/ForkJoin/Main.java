
import java.util.concurrent.ForkJoinPool;

public class Main {



    public static void main(String[] args) {
        String url = "https://lenta.ru/";
        String map = new ForkJoinPool().invoke(new UrlJoiner(url));
        System.out.println(map);


    }




}

