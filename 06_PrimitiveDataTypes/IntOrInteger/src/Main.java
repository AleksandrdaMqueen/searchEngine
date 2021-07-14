public class Main {
    public static void main(String[] args) {
        char o = 'Ё';
        int p = (int) o;
        Container container = new Container(1);
        container.addCount(5672);
        System.out.println(container.getCount());



        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.
        for(int i = 1040; i < 1106; i++){
            char c = (char) i;
            System.out.println(i + "-" + c);
        }
        System.out.println("Число присвоенное Ё = " + p);
    }
}

