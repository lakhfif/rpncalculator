package fr.rpn.calculator.Services;

import fr.rpn.calculator.core.db.CalculatorMemory;
import fr.rpn.calculator.core.stack.RpnStack;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class StackService {

    private CalculatorMemory memory;

    @PostConstruct
    public void initMemory() {
        memory = CalculatorMemory.init();
    }

    public RpnStack getStackById(String stackId) {
        return memory.getStacks().get(stackId);
    }

    public boolean pushValue(String stackId, double value) {
        var stack = memory.getStacks().get(stackId);
        return stack == null ? false : stack.getValues().add(value);
    }

    public Map<String, RpnStack> getAllStacks() {
        return memory.getStacks();
    }

    public RpnStack createStack(String stackId) {
        var stack = new RpnStack(stackId);
        return memory.getStacks().put(stackId, stack);
    }

    public RpnStack deleteStack(String stackId) {
        return memory.getStacks().remove(stackId);
    }


}