/**
 * CalculatorValue
 */
public class CalculatorValue {
    private long rightValue;
    private long leftValue;
    private String op;

    CalculatorValue() {
        init();
    }

    void init() {
        this.rightValue = 0;
        this.leftValue = 0;
        this.op = "";
    }

    void changeValueSign(Boolean isRight) {
        if (isRight) {
            this.rightValue *= -1;
        } else {
            this.leftValue *= -1;
        }
    }

    void addRightValue(int value) {
        if (value == -1) {
            this.rightValue *= 100;
        } else {
            this.rightValue = this.rightValue * 10 + value;
        }
    }

    void addLeftValue(int value) {
        if (value == -1) {
            this.leftValue *= 100;
        } else {
            this.leftValue = this.leftValue * 10 + value;
        }
    }

    long getRightValue() {
        return rightValue;
    }

    long getLeftValue() {
        return leftValue;
    }

    void setOP(String op) {
        this.op = op;
    }

    long getResult() {
        switch (op) {
            case "+":
                return (leftValue + rightValue);
            case "-":
                return (leftValue - rightValue);
            case "*":
                return (leftValue * rightValue);
            case "/":
                return (leftValue / rightValue);
            case "%":
                return (leftValue % rightValue);
            default:
                return 0;
        }
    }
}