public class Line {

    String num;
    String name;
    public Line(String name, String num){
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString()
    {
        return name + '\t';
    }

}
