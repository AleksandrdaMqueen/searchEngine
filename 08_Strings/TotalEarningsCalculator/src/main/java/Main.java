public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль
        nums(text);
    }
    public static   String nums (String text){
            String rub =  "руб";
            String name = "Вася";
            int end = text.indexOf(rub);
            int start = text.indexOf(name);
            while(start != -1){
                String nums = text.substring(start , end);
                return nums;
            }
        }


}
