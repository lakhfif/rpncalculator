package fr.rpn.calculator.Services;

import fr.rpn.calculator.db.CalculatorMemory;
import fr.rpn.calculator.operators.OperatorSymbol;
import fr.rpn.calculator.stack.RpnStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class StackService {

    private CalculatorMemory memory;

    @Autowired
    private CalculationService calculationService;

    @PostConstruct
    public void initMemory() {
        memory = CalculatorMemory.init();
    }

    public RpnStack getStackById(String stackId) {
        return memory.getStacks().get(stackId);
    }

    public boolean pushValue(String stackId, double value) {
        var stack = memory.getStacks().get(stackId);
        return stack.add(value);
    }

    public List<RpnStack> getAllStacks() {
        return new ArrayList<>(memory.getStacks().values());
    }

    public boolean createStack(String stackId) {
        var stack = new RpnStack(stackId);
        memory.getStacks().put(stackId, stack);
        return true;
    }

    public RpnStack deleteStack(String stackId) {
        return memory.getStacks().remove(stackId);
    }

    public double applyOperation(String stackId, OperatorSymbol symbol) {

        var stack = memory.getStacks().get(stackId);
        var operator = memory.getOperators().get(symbol);
        return calculationService.calculate(stack, operator);
    }

}