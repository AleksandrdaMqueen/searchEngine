public class Computer {
    private final Cpu cpu;
    private final RAM ram;
    private final HDD hdd;
    private final Display display;
    private final Keyboard keyboard;
    private String vendor;
    private String name;
    //====================================================================================================================================================================
    //Getter, Setter


    public Computer setRam(RAM ram) {
        return new Computer(cpu, ram, hdd, display, keyboard, vendor, name);
    }

    public Computer setHdd(HDD hdd) {
        return new Computer(cpu, ram, hdd, display, keyboard, vendor, name);
    }

    public Computer setKeyboard(Keyboard keyboard) {
        return new Computer(cpu, ram, hdd, display, keyboard, vendor, name);
    }

    public Computer setDisplay(Display display) {
        return new Computer(cpu, ram, hdd, display, keyboard, vendor, name);
    }

    public Computer setCpu(Cpu cpu) {
        return new Computer(cpu, ram, hdd, display, keyboard, vendor, name);
    }

    public Cpu getCpu() {
        return cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public HDD getHdd() {
        return hdd;
    }

    public Display getDisplay() {
        return display;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    //=====================================================================================================================================================================
    //Constructor
    public Computer(Cpu cpu, RAM ram, HDD hdd, Display display, Keyboard keyboard, String vendor, String name) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.display = display;
        this.vendor = vendor;
        this.keyboard = keyboard;
        this.name = name;
    }

    //================================================================================================================================================================
    //method


    @Override
    public String toString() {
        return "Computer" +
                "cpu:  " + cpu + '\n' +
                " ram:  " + ram + '\n' +
                " hdd: " + hdd + '\n' +
                " display:  " + display + '\n' +
                " keyboard:  " + keyboard + '\n' +
                " vendor:  " + vendor + '\n' +
                " name:  " + name
                ;
    }

    public double countWeight() {
        return display.getWeight() + keyboard.getWeight() + hdd.getWeight() + ram.getWeight() + cpu.getWeight();
    }


}
