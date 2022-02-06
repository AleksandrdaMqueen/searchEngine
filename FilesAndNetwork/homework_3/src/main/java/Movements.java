import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Movements {


    private static String pathMovementsCsv;

    public Movements(String pathMovementsCsv) {
        Movements.pathMovementsCsv = pathMovementsCsv;
    }

    public double getExpenseSum() {
        List<String> list = getFilledList(pathMovementsCsv);
        double res =0.0;

        for (String line : list) {

            String[] fragments = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            if (fragments.length == 9) {


                res += Double.parseDouble(fragments[7].replaceAll("\"", " ").replaceAll(",","."));

            } else if (fragments.length == 8) {

                res += Double.parseDouble(fragments[7].replaceAll("\"","").replaceAll(",","."));
            } else {
                System.out.println("Wrong line: " + line);
            }

        }

        return res;

    }


    public double getIncomeSum() {
        List<String> list = getFilledList(pathMovementsCsv);
        double res =0.0;

        for (String line : list) {

            String[] fragments = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            if (fragments.length == 9) {


                res += Double.parseDouble(fragments[6].replaceAll("\"", " ").replaceAll(",","."));

            } else if (fragments.length == 8) {

                res += Double.parseDouble(fragments[6].replaceAll("\"","").replaceAll(",","."));
            } else {
                System.out.println("Wrong line: " + line);
            }

        }

        return res;
    }

    private List<String> getFilledList(String cvsToGet) {
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(Paths.get(cvsToGet));
            list.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }


}



