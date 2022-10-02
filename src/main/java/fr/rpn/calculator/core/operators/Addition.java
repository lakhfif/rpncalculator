package fr.rpn.calculator.core.operators;


public class Addition extends AbstractOperator {

    public Addition() {
        name = "addition";
        symbol = OperatorSymbol.PLUS;
    }

    @Override
    public double apply(double x, double y) {
        return x + y;
    }
}
