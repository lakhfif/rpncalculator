package fr.rpn.calculator.Services;

import fr.rpn.calculator.operators.AbstractOperator;
import fr.rpn.calculator.stack.RpnStack;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public double calculate(RpnStack rpnStack, AbstractOperator operator) {
        if (rpnStack.getValues() != null && rpnStack.getValues().size() > 1) {
            var stack = rpnStack.getValues();
            var firstOperand = stack.pop().doubleValue();
            var secondOperand = stack.pop().doubleValue();
            var result = operator.apply(firstOperand, secondOperand);
            return stack.push(result);
        }
        return Double.NaN;
    }

}
