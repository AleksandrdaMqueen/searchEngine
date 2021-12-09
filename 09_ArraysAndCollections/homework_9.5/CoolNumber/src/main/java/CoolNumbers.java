
import java.util.*;

public class CoolNumbers {




    public static List<String> generateCoolNumbers() {
        ArrayList<String> numbers = new ArrayList<>();
        String[] letters = {"А","В","Е","К","М","Н","О","Р","С","Т","У","Х"};
        String[] num = {"111", "222", "333", "444", "555","666","777","888","999"};
        while(numbers.size() <= 2000000) {
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < letters.length; j++) {
                    for (int k = 0; k < 199; k++) {
                        numbers.add(letters[j] + num[i] +letters[j] + letters[j]+letters[j] + k);
                    }
                }
            } 
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
