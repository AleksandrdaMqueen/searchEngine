public class Main {
    public static void main(String[] args) {
        var a = new ArithmeticCalculator(2,2);
        var b = new ArithmeticCalculator(2, 0);
        System.out.println("2 плюс 2 равно " + a.calculate(Operation.ADD));
        System.out.println("Результат (8 - 5) * (3 + 2) = " + new ArithmeticCalculator(new ArithmeticCalculator(8, 5).calculate(Operation.SUBTRACT), new ArithmeticCalculator(3, 2).calculate(Operation.ADD)).calculate(Operation.MULTIPLY));
        System.out.println("Результат (2 + 2) * (3 - 2) = " + new ArithmeticCalculator(new ArithmeticCalculator(2,2).calculate(Operation.ADD), new ArithmeticCalculator(3,2).calculate(Operation.SUBTRACT)).calculate(Operation.MULTIPLY));
        System.out.println("Результат сложения: " + new ArithmeticCalculator(8, 9).calculate(Operation.ADD));
        System.out.println(new ArithmeticCalculator(1,2).calculate(Operation.SUBTRACT));
        System.out.println(ArithmeticCalculator.result);

    }


}