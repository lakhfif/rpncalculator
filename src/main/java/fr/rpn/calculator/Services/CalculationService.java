package fr.rpn.calculator.Services;

import fr.rpn.calculator.operators.AbstractOperator;
import fr.rpn.calculator.stack.RpnStack;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public double calculate(RpnStack stack, AbstractOperator operator) {
        if (stack != null && stack.size() > 1) {
            var firstOperand = stack.pop().doubleValue();
            var secondOperand = stack.pop().doubleValue();
            var result = operator.apply(firstOperand, secondOperand);
            return stack.push(result);
        }
        return Double.NaN;
    }

}
