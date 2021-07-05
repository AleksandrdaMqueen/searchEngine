public class ArithmeticCalculator {


    public ArithmeticCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    private  int b;
    private  int a;
    public static Operation type;
    public static int result;

    public  int getA() {
        return a;
    }

    public static Operation getType() {
        return type;
    }

    public  int getB() {
        return b;
    }

    public static int getResult() {
        return result;
    }


    public  int calculate(Operation type) {
        if (type == Operation.ADD) {
            return a + b;

        } else if (type == Operation.MULTIPLY) {
            return a * b;
        } else if (type == Operation.SUBTRACT) {
            return a - b;
        }


        return result;
    }


}