package fr.rpn.calculator.Services;

import fr.rpn.calculator.db.CalculatorMemory;
import fr.rpn.calculator.operators.AbstractOperator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorService {

    private CalculatorMemory memory;

    @PostConstruct
    public void initMemory() {
        memory = CalculatorMemory.init();
    }

    public List<AbstractOperator> getAllOperators() {
        return new ArrayList<>(memory.getOperators().values());
    }
}
