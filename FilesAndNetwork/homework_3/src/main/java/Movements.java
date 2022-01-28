import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Movements {

    String pathMovementsCsv;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }

    public double getExpenseSum() {


        double sum = 0.0;
        try {
            List<String> list =  Files.readAllLines(Paths.get(pathMovementsCsv));

            for (String line: list) {
                String[] fragments = line.split(",");
                if(fragments.length != 8){
                    System.out.println("Неверный формат!  " + line);;
                }else {
                    list.add(line);
                    sum =+ Double.parseDouble(fragments[7]);
                }
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }



        return sum;

    }


    public static double getIncomeSum() {
        return 0.0;
    }


}
