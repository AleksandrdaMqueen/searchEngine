import java.util.*;

public class Main {


    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {

        List<String> numbers = CoolNumbers.generateCoolNumbers();
        HashSet<String> numbers1 = new HashSet<>(numbers);
        TreeSet<String> numbers2  = new TreeSet<>(numbers);
        List<String> numbers3 = new ArrayList<>(numbers);
        Collections.sort(numbers3);

      
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String num = scanner.nextLine();
            long startTime = System.nanoTime();
            boolean isContains = CoolNumbers.bruteForceSearchInList(numbers, num);
            long endTime = System.nanoTime();
            if(isContains) {
                System.out.println("Номер найден! Поиск занял: " + (endTime - startTime) + "ns");
            }else {
                System.out.println("Номер не найден");
            }


            long startTime2 = System.nanoTime();
            boolean isContains2 = CoolNumbers.searchInHashSet(numbers1, num);
            long endTime2 = System.nanoTime();
            if(isContains2) {
                System.out.println("Номер найден! Поиск занял: " + (endTime2 - startTime2) + "ns");
            }else {
                System.out.println("Номер не найден");
            }


            long startTime3 = System.nanoTime();
            boolean isContains3 = CoolNumbers.binarySearchInList(numbers3, num);
            long endTime3 = System.nanoTime();
            if(isContains3) {
                System.out.println("Номер найден! Поиск занял: " + (endTime3 - startTime3) + "ns");
            }else {
                System.out.println("Номер не найден");
            }

            long startTime4 = System.nanoTime();
            boolean isContains4 = CoolNumbers.searchInTreeSet(numbers2, num);
            long endTime4 = System.nanoTime();
            if(isContains4) {
                System.out.println("Номер найден! Поиск занял: " + (endTime4 - startTime4) + "ns");
            }else {
                System.out.println("Номер не найден");
            }

        }

    }
}
