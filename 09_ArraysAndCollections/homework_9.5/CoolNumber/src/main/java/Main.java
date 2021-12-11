import java.util.*;

public class Main {


    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>();
        HashSet<String> numbers1 = new HashSet<>();
        TreeSet<String> numbers2  = new TreeSet<>();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String num = scanner.nextLine();
            System.out.println("Введите искомый номер:");

            numbers.generateCoolNumbers();


            long startTime2 = System.nanoTime();
            boolean isContains = CoolNumbers.bruteForceSearchInList(numbers, num);
            long endTime2 = System.nanoTime();
            if(isContains){
                System.out.println("Поиск номера перебором заял: " + (endTime2 - startTime2) + "ns");
            }else{
                System.out.println("Номер не найден");
            }



            long startTime3 = System.nanoTime();
            boolean isContains2 = CoolNumbers.binarySearchInList(numbers, num);
            long endTime3 = System.nanoTime();
            if(isContains2){
                System.out.println("Поиск номера перебором заял: " + (endTime3 - startTime3) + "ns");
            }else{
                System.out.println("Номер не найден");
            }

            long startTime4 = System.nanoTime();
            boolean isContains3 = CoolNumbers.searchInHashSet(numbers1, num);
            long endTime4 = System.nanoTime();
            if(isContains3){
                System.out.println("Поиск номера перебором заял: " + (endTime4 - startTime4) + "ns");
            }else{
                System.out.println("Номер не найден");
            }

            long startTime5 = System.nanoTime();

            long endTime5 = System.nanoTime();
            boolean isContains4 = CoolNumbers.searchInTreeSet(numbers2, num);
            if(isContains4){
                System.out.println("Поиск номера перебором заял: " + (endTime5 - startTime5) + "ns");
            }else{
                System.out.println("Номер не найден");
            }


        }

    }
}
