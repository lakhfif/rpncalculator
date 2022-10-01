package fr.rpn.calculator.Services;

import fr.rpn.calculator.operators.AbstractOperator;
import fr.rpn.calculator.stack.RpnStack;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public double calculate(RpnStack stack, AbstractOperator operator) {
        var firstOperand = stack.pop().doubleValue();
        var secondOperand = stack.pop().doubleValue();
        return operator.apply(firstOperand, secondOperand);
    }

}
