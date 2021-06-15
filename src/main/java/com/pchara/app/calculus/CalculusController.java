package com.pchara.app.calculus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculusController {

    CalculusService calculusService = new CalculusService();
    
    @GetMapping("/sum/{a}/{b}")
    public ResponseEntity<CalculusResponse> sum(@PathVariable("a") Number a, @PathVariable("b") Number b) {
        Number result = calculusService.sum(a, b);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sub/{a}/{b}")
    public ResponseEntity<CalculusResponse> sub(@PathVariable("a") Number a, @PathVariable("b") Number b) {
        Number result = calculusService.sub(a, b);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/multiply/{a}/{b}")
    public ResponseEntity<CalculusResponse> multiply(@PathVariable("a") Number a, @PathVariable("b") Number b) {
        Number result = calculusService.multiply(a, b);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/division/{a}/{b}")
    public ResponseEntity<CalculusResponse> division(@PathVariable("a") Number a, @PathVariable("b") Number b) {
        Number result = calculusService.division(a, b);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pow/{a}/{b}")
    public ResponseEntity<CalculusResponse> pow(@PathVariable("a") Number a, @PathVariable("b") Number b) {
        Number result = calculusService.pow(a, b);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

}