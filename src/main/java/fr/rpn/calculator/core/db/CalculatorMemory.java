package fr.rpn.calculator.core.db;

import fr.rpn.calculator.core.operators.*;
import fr.rpn.calculator.core.stack.RpnStack;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CalculatorMemory {

    private Map<String, RpnStack> stacks;
    private Map<OperatorSymbol, AbstractOperator> operators;
    private static CalculatorMemory memory = null;

    private CalculatorMemory() {

        stacks = new HashMap<>();

        operators = Map.of(
                OperatorSymbol.PLUS, new Addition(),
                OperatorSymbol.MINUS, new Subtraction(),
                OperatorSymbol.DIVIDE, new Division(),
                OperatorSymbol.MULTIPLY, new Multiplication()
        );
    }

    public static CalculatorMemory init() {
        if (memory == null) {
            memory = new CalculatorMemory();
        }
        return memory;
    }

}
