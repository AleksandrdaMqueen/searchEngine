import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Movements {


    private static String pathMovementsCsv;

    public Movements(String pathMovementsCsv) {
        Movements.pathMovementsCsv = pathMovementsCsv;
    }

    public double getExpenseSum() {
        List<String> list = getFilledList(pathMovementsCsv);
        double sum = 0.0;

        for (String line : list) {
            String[] fragments = line.split(",");

            if (fragments.length == 8) {

                sum = +Double.parseDouble(fragments[7]);
            } else if (fragments.length == 9) {
                sum = +Double.parseDouble(fragments[7].replaceAll("\"", "") + "." + fragments[8].replaceAll("\"", ""));
            }
        }
        return sum;

    }


    public double getIncomeSum() {
        List<String> list = getFilledList(pathMovementsCsv);
        double sum = 0.0;

        for (String line : list) {
            String[] fragments = line.split(",");

            if (fragments.length == 8) {

                sum += Double.parseDouble(fragments[7]);
            } else if (fragments.length == 9) {
                sum += Double.parseDouble(fragments[6].replaceAll("\"", "") + "." +fragments[7].replaceAll("\"", ""));
            } else {
                System.out.println("Неверный формат: " + line);

            }
        }
        return sum;
    }

    private List<String> getFilledList(String cvsToGet) {
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(Paths.get(cvsToGet));
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.addAll(list);


        return list;
    }


}
