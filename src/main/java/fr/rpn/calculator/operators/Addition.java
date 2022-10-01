package fr.rpn.calculator.operators;


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
