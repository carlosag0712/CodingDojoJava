package codingDojo.JAVA_OOP.Calculator_II;

public class CalculatorTest {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.setOperandOne(1.50);
        calc.setOperation("+");
        calc.setOperandTwo(2.50);
        calc.performOperation();
        double result = calc.getResult();
        System.out.println(result);


    }
}
