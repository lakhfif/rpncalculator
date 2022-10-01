package fr.rpn.calculator.operators;

public class Division extends AbstractOperator {

    public Division() {
        name = "division";
        symbol = OperatorSymbol.DIVIDE;
    }

    @Override
    public double apply(double x, double y) {
        return x / y;
    }
}
