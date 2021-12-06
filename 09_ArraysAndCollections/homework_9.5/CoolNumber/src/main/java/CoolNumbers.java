import java.util.*;

public class CoolNumbers {

    private static  String generateFirstLetter(){
        String letters = "АВЕКМНОРСТУХ";
        String firstLetter = String.valueOf(letters.charAt((int) (Math.random() * (letters.length() - 1)) + 1));
        return firstLetter;
    }

    private static String generateFirstThreeNumbers(){
        String firstNum =  String.valueOf((int) (Math.random() * 8) + 1);
        String secNum =  String.valueOf((int) (Math.random() * 8) + 1);
        String thirdNum =  String.valueOf((int) (Math.random() * 8) + 1);
        String firstThreeNumbers = firstNum + secNum + thirdNum;

        return firstThreeNumbers;
    }

    private static String generateTwoLetters(){
        String letters = "АВЕКМНОРСТУХ";
        String  firstLetter = String.valueOf(letters.charAt((int) (Math.random()  * letters.length() - 1) + 1));
        String secLetter = String.valueOf(letters.charAt((int) (Math.random()  * letters.length() - 1) + 1));
        String twoLetters = firstLetter + secLetter;
        return twoLetters;
    }

    private static  String generateRegion(){
        String region = String.valueOf((int)(Math.random() * 198) + 1);
        return  region;
    }



    public static List<String> generateCoolNumbers() {
        ArrayList<String> numbers = new ArrayList<>();
        while(numbers.size() <= 2000000) {
            numbers.add(generateFirstLetter() + generateFirstThreeNumbers() + generateTwoLetters() + generateRegion());
        }

        for(String nums : numbers){
            System.out.println(nums);
        }

        return numbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        boolean isContains = list.contains(number);
        if(isContains){
            return true;
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        int index = Collections.binarySearch(sortedList, number);
        if(index > -1){
            return true;
        }
        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        boolean isContains = hashSet.contains(number);
        if (isContains){
            return true;
        }
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        boolean isContains = treeSet.contains(number);
        if (isContains){
            return true;
        }
        return false;
    }


}
