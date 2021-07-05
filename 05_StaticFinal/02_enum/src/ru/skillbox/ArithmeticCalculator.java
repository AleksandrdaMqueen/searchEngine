public class ArithmeticCalculator {
    private static int b;
    private static int a;
    public static Operation type;
    private static int result;

    public static int getA() {
        return a;
    }

    public static Operation getType() {
        return type;
    }


    public static int getB() {
        return b;
    }

    public static int getResult() {
        return result;
    }


    public ArithmeticCalculator() {
        this.a = a;
        this.b = b;
        this.type = type;
        this.result = result;

    }

    public static void calculate(int a, int b, Operation type) {
        if (type == Operation.ADD) {
            int result = a + b;
            System.out.println("Результат сложния: " + result);
        } else if (type == Operation.MULTIPLY) {
            int result = a * b;
            System.out.println("Результат умножения: " + result);
        } else if (type == Operation.SUBTRACT) {
            int result = a - b;
            System.out.println("Результат вычетания: " + result);
        }


    }

}
