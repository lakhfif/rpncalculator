package fr.rpn.calculator.core.operators;

public class Multiplication extends AbstractOperator {

    public Multiplication() {
        name = "multiplication";
        symbol = OperatorSymbol.MULTIPLY;
    }

    @Override
    public double apply(double x, double y) {
        return x * y;
    }
}
