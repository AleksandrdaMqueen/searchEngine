public class Main {
    public static void main(String[] args) {
        Cpu cpu =  new Cpu(1,2,3,4);
        HDD hdd = new  HDD(HDDtype.SSD,8,9);
        RAM ram = new RAM(RAMtype.DDR,8,1);
        Display display = new Display(17,DisplayType.TN,3);
        Keyboard keyboard = new Keyboard(KeyboardType.MECHANICAL,true,8);
        Computer MacBook = new Computer(cpu, ram, hdd, display, keyboard, "Apple","MacBook");
        System.out.println(MacBook);
        System.out.println("Общий вес всех компонентов:" + MacBook.countWeight());




    }
}

