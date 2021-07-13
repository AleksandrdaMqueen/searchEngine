public class Computer {
    private  Cpu cpu;
    private  RAM ram;
    private  HDD hdd;
    private  Display display;
    private  Keyboard keyboard;



    private final String vendor;
    private final String name;
    //====================================================================================================================================================================
    //Getter, Setter

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
    
    
    public Computer setVendor(String vendor){
        return new Computer(cpu , ram, hdd, display ,keyboard, vendor, name);
    }

    public Computer setName(String name){
        return new Computer(cpu , ram, hdd, display ,keyboard, vendor, name);
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


