package fr.rpn.calculator.Services;

import fr.rpn.calculator.db.CalculatorMemory;
import fr.rpn.calculator.stack.RpnStack;
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

    public Map.Entry<String, RpnStack> getStackById(String stackId) {
        var stack = memory.getStacks().get(stackId);
        return Map.entry(stackId, stack);
    }

    public boolean pushValue(String stackId, double value) {
        var stack = memory.getStacks().get(stackId);
        return stack == null ? false : stack.add(value);
    }

    public Map<String, RpnStack> getAllStacks() {
        return memory.getStacks();
    }

    public Map.Entry<String, RpnStack> createStack(String stackId) {
        var stack = new RpnStack();
        memory.getStacks().put(stackId, stack);
        return Map.entry(stackId, stack);
    }

    public Map.Entry<String, RpnStack> deleteStack(String stackId) {
        var stack = memory.getStacks().remove(stackId);
        return Map.entry(stackId, stack);
    }


}