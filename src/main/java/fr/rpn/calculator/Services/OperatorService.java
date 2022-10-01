package fr.rpn.calculator.Services;

import fr.rpn.calculator.db.CalculatorMemory;
import fr.rpn.calculator.operators.AbstractOperator;
import fr.rpn.calculator.operators.OperatorSymbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorService {

    private CalculatorMemory memory;

    @Autowired
    private CalculationService calculationService;

    @PostConstruct
    public void initMemory() {
        memory = CalculatorMemory.init();
    }

    public List<AbstractOperator> getAllOperators() {
        return new ArrayList<>(memory.getOperators().values());
    }

    public double applyOperation(String stackId, OperatorSymbol symbol) {
        var stack = memory.getStacks().get(stackId);
        var operator = memory.getOperators().get(symbol);
        if (stack != null && symbol != null) {
            return calculationService.calculate(stack, operator);
        }
        return Double.NaN;
    }

}
