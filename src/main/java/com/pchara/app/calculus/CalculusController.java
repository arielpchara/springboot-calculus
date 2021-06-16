package com.pchara.app.calculus;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculusController {

    @Autowired
    MessageSource messageSource;
    
    CalculusService calculusService = new CalculusService();
    Logger logger = LoggerFactory.getLogger(CalculusController.class);
    
    @GetMapping("/sum/{a}/{b}")
    public ResponseEntity<CalculusResponse> sum(@PathVariable("a") String a, @PathVariable("b") String b, Locale locale) throws CalculusException {
        Number numberA;
        Number numberB;
        try {
            numberA = Float.parseFloat(a);
            numberB = Float.parseFloat(b);
        } catch (Exception e) {
            throw new CalculusException(messageSource.getMessage("calculus.invalidParams", null, locale));
        }
        Number result = calculusService.sum(numberA, numberB);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sub/{a}/{b}")
    public ResponseEntity<CalculusResponse> sub(@PathVariable("a") String a, @PathVariable("b") String b, Locale locale) {
        Number numberA;
        Number numberB;
        try {
            numberA = Float.parseFloat(a);
            numberB = Float.parseFloat(b);
        } catch (Exception e) {
            throw new CalculusException(messageSource.getMessage("calculus.invalidParams", null, locale));
        }
        Number result = calculusService.sub(numberA, numberB);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/multiply/{a}/{b}")
    public ResponseEntity<CalculusResponse> multiply(@PathVariable("a") String a, @PathVariable("b") String b, Locale locale) {
        Number numberA;
        Number numberB;
        try {
            numberA = Float.parseFloat(a);
            numberB = Float.parseFloat(b);
        } catch (Exception e) {
            throw new CalculusException(messageSource.getMessage("calculus.invalidParams", null, locale));
        }
        Number result = calculusService.multiply(numberA, numberB);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/division/{a}/{b}")
    public ResponseEntity<CalculusResponse> division(@PathVariable("a") String a, @PathVariable("b") String b, Locale locale) {
        Number numberA;
        Number numberB;
        try {
            numberA = Float.parseFloat(a);
            numberB = Float.parseFloat(b);
        } catch (Exception e) {
            throw new CalculusException(messageSource.getMessage("calculus.invalidParams", null, locale));
        }
        Number result = calculusService.division(numberA, numberB);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pow/{a}/{b}")
    public ResponseEntity<CalculusResponse> pow(@PathVariable("a") String a, @PathVariable("b") String b, Locale locale) {
        Number numberA;
        Number numberB;
        try {
            numberA = Float.parseFloat(a);
            numberB = Float.parseFloat(b);
        } catch (Exception e) {
            throw new CalculusException(messageSource.getMessage("calculus.invalidParams", null, locale));
        }
        Number result = calculusService.pow(numberA, numberB);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Calculus>> history() {
        List<Calculus> history = calculusService.getHistory();
        return ResponseEntity.ok(history);
    }

}