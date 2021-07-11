public class RAM {
    private final RAMtype type;
    private final int volume;

    public RAMtype getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    private final double weight;
    //===================================================================================================================================================================
    //constructor
    public RAM(RAMtype type, int volume, int weight){
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }
}
