public class Main {

  public static void main(String[] args) {

    Stringpublic class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль
        int vasya = Integer.parseInt(getVasyaEarnings(text));
        int petya = Integer.parseInt(getPetyasEarnings(text));
        int masha = Integer.parseInt(getMashasEarnings(text));
        System.out.println(vasya + petya + masha);


    }

    public static String getVasyaEarnings(String text) {
        String charsetStr = "заработал ";
        String charset = "000";
        int end = text.indexOf(charset) + charset.length();
        int start = text.indexOf(charsetStr) + charsetStr.length();
        String encoding = text.substring(start, end);
        return encoding;
    }

    public static String getPetyasEarnings(String text) {
        String charsetStr = "Петя - ";
        String charset = "563";
        int end = text.indexOf(charset) + charset.length();
        int start = text.indexOf(charsetStr) + charsetStr.length();
        String endcoding = text.substring(start, end);
        return endcoding;
    }

    public static String getMashasEarnings(String text) {
        String charsetStr = " а Маша - ";
        String charset = "0000";
        int end = text.indexOf(charset) + charset.length();
        int start = text.indexOf(charsetStr) + charsetStr.length();
        String endcoding = text.substring(start, end);
        return endcoding;
    }
} text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
  }

}
