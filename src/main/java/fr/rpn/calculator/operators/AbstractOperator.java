package fr.rpn.calculator.operators;

import lombok.Getter;

@Getter
public abstract class AbstractOperator {

    protected OperatorSymbol symbol;
    protected String name;

    public abstract double apply(double x, double y);
}
