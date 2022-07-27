import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        PrintWriter writer = new PrintWriter("C:\\Users\\abake\\Desktop\\java_basics-master (1)\\java_basics-master\\Performance\\CarNumberGenerator\\res\\numders.txt");
        int regionCode = 199;
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        for (int i = 0; i < 100; i++) {
            StringBuilder builder = new StringBuilder();

            for (int number = 1; number < 1000; number++) {

                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(regionCode, 2));
                            builder.append("\n");

                        }
                    }
                }
            }
            writer.write(builder.toString());
        }
        writer.flush();
        writer.close();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder builder = new StringBuilder();
        builder.append(number);
        int padSize = numberLength - builder.length();

        for (int i = 0; i < padSize; i++) {
            builder.append('0').append(builder);
        }

        return builder.toString();
    }
}

