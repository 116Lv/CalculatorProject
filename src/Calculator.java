import java.util.ArrayList;
import java.util.List;

public class Calculator{
    private int num1;
    private String oper;
    private int num2;
    private int result;

    private ArrayList<Calculator> Lists = new ArrayList<>();

    public Calculator() {}

    public int calculate(int num1, String oper, int num2) {

        // 연산자에 따른 계산처리
        switch(oper) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                result = -9999;
        }
        if(result != -9999) {
            Calculator calculator = new Calculator();
            calculator.setNum1(num1);
            calculator.setOper(oper);
            calculator.setNum2(num2);
            calculator.setResult(result);
            Lists.add(calculator);
        }
        return result;
    }

    public int getNum1() {
        return this.num1;
    }

    public String getOper() {
        return this.oper;
    }

    public int getNum2() {
        return this.num2;
    }

    public int getResult() {
        return this.result;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    private void setResult(int result) {
        this.result = result;
    }

    public List<Calculator> getLists() {
        return Lists;
    }

    public void removeFirst() {
        if(!Lists.isEmpty()) {
            Lists.remove(0);
        }
    }
}
