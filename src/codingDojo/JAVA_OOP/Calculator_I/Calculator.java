package codingDojo.JAVA_OOP.Calculator_I;

public class Calculator {
    private double OperandOne;
    private double OperandTwo;
    private String Operation;
    private double result;

    public double getOperandOne() {
        return OperandOne;
    }

    public void setOperandOne(double operandOne) {
        OperandOne = operandOne;
    }

    public double getOperandTwo() {
        return OperandTwo;
    }

    public void setOperandTwo(double operandTwo) {
        OperandTwo = operandTwo;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void performOperation(){
        if(Operation == "+"){
            result = OperandOne + OperandTwo;
        }else if (Operation == "-"){
            result = OperandOne-OperandTwo;
        }else{
            System.out.println("Invalid Operation");
        }
    }


}
