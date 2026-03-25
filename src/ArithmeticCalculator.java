import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private T num1;
    private OperatorType ot;
    private T num2;
    private double result;

    private ArrayList<ArithmeticCalculator<T>> Lists = new ArrayList<>();

    public ArithmeticCalculator() {}

    public double calculate(T num1, OperatorType ot, T num2) {

        double n1 = num1.doubleValue();
        double n2 = num2.doubleValue();

        // 연산자에 따른 계산처리
        switch(ot) {
            case ADD:
                result = n1 + n2;
                break;
            case SUB:
                result = n1 - n2;
                break;
            case MUL:
                result = n1 * n2;
                break;
            case DIV:
                result = n1 / n2;
                break;
            default:
                result = -9999;
        }
        if(result != -9999) {
            ArithmeticCalculator<T> calculator = new ArithmeticCalculator<T>();
            calculator.setNum1(num1);
            calculator.setOt(ot);
            calculator.setNum2(num2);
            calculator.setResult(result);
            Lists.add(calculator);
        }
        return result;
    }

    public T getNum1() {
        return this.num1;
    }

    public OperatorType getOt() {
        return this.ot;
    }

    public T getNum2() {
        return this.num2;
    }

    public double getResult() {
        return this.result;
    }

    public void setNum1(T num1) {
        this.num1 = num1;
    }

    public void setOt(OperatorType ot) {
        this.ot = ot;
    }

    public void setNum2(T num2) {
        this.num2 = num2;
    }

    private void setResult(double result) {
        this.result = result;
    }

    public List<ArithmeticCalculator<T>> getLists() {
        return Lists;
    }

    public void removeFirst() {
        if(!Lists.isEmpty()) {
            Lists.remove(0);
        }
    }

}


