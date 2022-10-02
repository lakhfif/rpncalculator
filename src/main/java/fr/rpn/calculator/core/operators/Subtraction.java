package fr.rpn.calculator.core.operators;

public class Subtraction extends AbstractOperator {

    public Subtraction() {
        name = "subtraction";
        symbol = OperatorSymbol.MINUS;
    }

    @Override
    public double apply(double x, double y) {
        return x - y;
    }
}
