import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Movements {


    private static String pathMovementsCsv;

    public Movements(String pathMovementsCsv) {
        Movements.pathMovementsCsv = pathMovementsCsv;
    }

    public double getExpenseSum() {
        List<String> list = getFilledList(pathMovementsCsv);
        double sum = 0.0;

        for (String line : list) {
            line = line.replace("\"", "");
            String[] fragments = line.split(",");
            if (fragments.length == 8) {
                sum += Double.parseDouble(fragments[7]);
                System.out.println(fragments[7]);
            } else if (fragments.length == 9 ) {
                fragments[7] = fragments[7] + "." + fragments[8];

                fragments[8] = "0";
                sum += Double.parseDouble(fragments[7]);

            } else {
                System.out.println("Wrong line: " + line);
            }

        }
        return sum;

    }


    public double getIncomeSum() {
        List<String> list = getFilledList(pathMovementsCsv);
        double sum = 0.0;


        for (String line : list) {
            line = line.replace("\"", "");
            String[] fragments = line.split(",");
            if (fragments.length == 8) {
                sum += Double.parseDouble(fragments[6]);
                System.out.println(fragments[6]);
            } else if (fragments.length == 9) {
                fragments[6] = fragments[6] + "." + fragments[7];

                fragments[7] = "0";
                sum += Double.parseDouble(fragments[6]);
                System.out.println(fragments[6]);

            } else {
                System.out.println("Wrong line: " + line);
            }
        }
        return sum;
    }

    private List<String> getFilledList(String cvsToGet) {
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(Paths.get(cvsToGet));
            list.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.addAll(list);


        return list;
    }


}

