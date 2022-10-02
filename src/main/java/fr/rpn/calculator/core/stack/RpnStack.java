package fr.rpn.calculator.core.stack;


import lombok.Getter;

import java.util.Stack;

@Getter
public class RpnStack {

    private Stack<Double> values;
    private String id;

    public RpnStack(String id) {
        this.id = id;
        values = new Stack<>();
    }
}
