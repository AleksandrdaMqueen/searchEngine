public class Station {
    private  String name;
    private  String lineNum;
    public Station( String lineNum,String name){
        this.lineNum = lineNum;
        this.name = name;

    }

    @Override
    public String toString() {
        return
                  name + '\t'
                ;
    }
}
