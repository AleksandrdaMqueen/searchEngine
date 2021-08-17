public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль
        System.out.println(nums(text));

    }
    public static   String nums (String text){
            String rub =  " руб";
            String name = " 5";
            int mid = text.indexOf(name);
            int start = text.indexOf(rub);
            int end = text.lastIndexOf(' ', mid);
            String encoding = text.substring(end , start) ;
            return encoding;
        }


}
