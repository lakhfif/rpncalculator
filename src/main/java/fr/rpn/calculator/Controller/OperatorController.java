package fr.rpn.calculator.Controller;


import fr.rpn.calculator.Services.OperatorService;
import fr.rpn.calculator.Services.StackService;
import fr.rpn.calculator.operators.AbstractOperator;
import fr.rpn.calculator.operators.OperatorSymbol;
import fr.rpn.calculator.stack.RpnStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rpn/op")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private StackService stackService;


    @GetMapping
    public String ping() {
        return "Operator Api is ready";
    }


    @GetMapping("/all")
    public ResponseEntity<List<AbstractOperator>> getAvailableOperators() {
        var operators = operatorService.getAllOperators();
        if (operators.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(operators);
    }

    @PostMapping("/{op}/stack/{stackId}")
    public ResponseEntity<RpnStack> applyOperation(@PathVariable String op, @PathVariable String stackId) {
        var result = operatorService.applyOperation(stackId, OperatorSymbol.valueOf(op.toUpperCase()));
        if (Double.isNaN(result)) {
            return ResponseEntity.unprocessableEntity().build();
        }
        var stack = stackService.getStackById(stackId);
        return ResponseEntity.ok(stack);
    }
}
