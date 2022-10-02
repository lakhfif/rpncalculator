package fr.rpn.calculator.core.operators;

public class Division extends AbstractOperator {

    public Division() {
        name = "division";
        symbol = OperatorSymbol.DIVIDE;
    }

    @Override
    public double apply(double x, double y) {
        return y == 0d ? Double.NaN : x / y;
    }
}
