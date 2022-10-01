package fr.rpn.calculator.stack;


import lombok.Getter;

import java.util.Stack;

@Getter
public class RpnStack extends Stack<Double> {

    private String id;

    public RpnStack(String id) {
        super();
        this.id = id;
    }
}
