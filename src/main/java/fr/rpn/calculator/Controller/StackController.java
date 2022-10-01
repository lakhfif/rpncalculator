package fr.rpn.calculator.Controller;

import fr.rpn.calculator.Services.StackService;
import fr.rpn.calculator.stack.RpnStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rpn/stack")
public class StackController {

    @Autowired
    StackService stackService;

    @GetMapping
    public String ping() {
        return "Stack Api is ready";
    }

    @PostMapping
    public ResponseEntity<RpnStack> addNewStack(@RequestBody String stackId) {
        var stack = stackService.createStack(stackId);
        if (stack == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(stack);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, RpnStack>> getAvailableStacks() {
        var stacks = stackService.getAllStacks();
        if (stacks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(stacks);
    }

    @GetMapping("/{stackId}")
    public ResponseEntity<RpnStack> getStack(@PathVariable String stackId) {
        var stack = stackService.getStackById(stackId);
        if (stack == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(stack);
    }

    @DeleteMapping("/{stackId}")
    public ResponseEntity<RpnStack> deleteStack(@PathVariable String stackId) {
        var stack = stackService.deleteStack(stackId);
        if (stack == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(stack);
    }

    @PostMapping("/{stackId}")
    public ResponseEntity<RpnStack> pushValue(@PathVariable String stackId, @RequestBody double value) {
        var isPushed = stackService.pushValue(stackId, value);
        if (isPushed) {
            var stack = stackService.getStackById(stackId);
            return ResponseEntity.ok(stack);
        }
        return ResponseEntity.unprocessableEntity().build();
    }


}
