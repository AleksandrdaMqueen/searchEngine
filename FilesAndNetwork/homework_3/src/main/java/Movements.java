import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Movements {

    private  static String pathMovementsCsv;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }

    public double getExpenseSum() {

        List<String> list = getFilledList(pathMovementsCsv);
        double sum = 0.0;
        for (String line :list){
            String[] fragments = line.split(",");
            if (fragments.length != 8){
                System.out.println("Неверный формат: " + line);

            }
            else {
                list.add(line);
                sum += Double.parseDouble(fragments[7]);
                return sum;
            }
        }

        return sum;

    }


    public static double getIncomeSum() {
        List<String> list = getFilledList(pathMovementsCsv);
        double sum = 0.0;
        for (String line :list){
            String[] fragments = line.split(",");
            if (fragments.length != 8){
                System.out.println("Неверный формат: " + line);

            }
            else {
                list.add(line);
                sum += Double.parseDouble(fragments[6]);
                return sum;
            }
        }

        return sum;
    }

    private static List<String> getFilledList(String cvsToGet){
        List<String> list = new ArrayList<>();
        try {
            list =  Files.readAllLines(Paths.get(cvsToGet));
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.addAll(list);


        return list;
    }


}
