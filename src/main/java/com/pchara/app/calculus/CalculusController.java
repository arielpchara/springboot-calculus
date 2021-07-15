package com.pchara.app.calculus;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.pchara.app.calculus.model.Calculus;
import com.pchara.app.calculus.model.GroupByOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculusController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    CalculusRepository calculusRepository;
    
    @Autowired
    CalculusService calculusService;

    Logger logger = LoggerFactory.getLogger(CalculusController.class);
    
    @GetMapping("/sum/{a}/{b}")
    public ResponseEntity<CalculusResponse> sum(@PathVariable("a") String a, @PathVariable("b") String b, Locale locale) throws CalculusException {
        Double numberA;
        Double numberB;
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
        } catch (Exception e) {
            throw new CalculusException(messageSource.getMessage("calculus.invalidParams", null, locale));
        }
        Double result = calculusService.sum(numberA, numberB);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sub/{a}/{b}")
    public ResponseEntity<CalculusResponse> sub(@PathVariable("a") String a, @PathVariable("b") String b, Locale locale) {
        Double numberA;
        Double numberB;
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
        } catch (Exception e) {
            throw new CalculusException(messageSource.getMessage("calculus.invalidParams", null, locale));
        }
        Double result = calculusService.sub(numberA, numberB);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/multiply/{a}/{b}")
    public ResponseEntity<CalculusResponse> multiply(@PathVariable("a") String a, @PathVariable("b") String b, Locale locale) {
        Double numberA;
        Double numberB;
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
        } catch (Exception e) {
            throw new CalculusException(messageSource.getMessage("calculus.invalidParams", null, locale));
        }
        Double result = calculusService.multiply(numberA, numberB);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/division/{a}/{b}")
    public ResponseEntity<CalculusResponse> division(@PathVariable("a") String a, @PathVariable("b") String b, Locale locale) {
        Double numberA;
        Double numberB;
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
        } catch (Exception e) {
            throw new CalculusException(messageSource.getMessage("calculus.invalidParams", null, locale));
        }
        Double result = calculusService.division(numberA, numberB);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pow/{a}/{b}")
    public ResponseEntity<CalculusResponse> pow(@PathVariable("a") String a, @PathVariable("b") String b, Locale locale) {
        Double numberA;
        Double numberB;
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
        } catch (Exception e) {
            throw new CalculusException(messageSource.getMessage("calculus.invalidParams", null, locale));
        }
        Double result = calculusService.pow(numberA, numberB);
        CalculusResponse response = new CalculusResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Calculus>> history() {
        List<Calculus> history = calculusRepository.findAll();
        return ResponseEntity.ok(history);
    }

    @GetMapping("/history/occurrence/top3")
    public ResponseEntity<List<GroupByOperation>> groupByOperation() {
        List<GroupByOperation> result = calculusRepository.groupByOperations(PageRequest.of(0, 3));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/history/result/top3")
    public ResponseEntity<List<Calculus>> groupByResult() {
        Page<Calculus> result = calculusRepository.findAll(
            PageRequest.of(0, 3, Sort.by("result").descending())
        );
        return ResponseEntity.ok(result.getContent());
    }


    @GetMapping("/history/highest-results-by-operation")
    public ResponseEntity<Map<String, List<Calculus>>> highestResults() {
        Map<String, List<Calculus>> result = new HashMap<String, List<Calculus>>();
        List<GroupByOperation> results = calculusRepository.groupByOperations();
        for(GroupByOperation op : results) {
            Page<Calculus> calculus = calculusRepository.findAllByOperation(op.getOperation(), PageRequest.of(0, 3, Sort.by("result").descending()));
            result.put(op.getOperation(), calculus.getContent());
        }
        return ResponseEntity.ok(result);
    }

}