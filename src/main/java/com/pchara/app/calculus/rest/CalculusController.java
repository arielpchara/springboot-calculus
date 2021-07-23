package com.pchara.app.calculus.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.pchara.app.calculus.entities.Calculus;
import com.pchara.app.calculus.entities.CalculusResponse;
import com.pchara.app.calculus.entities.GroupByOperation;
import com.pchara.app.calculus.exceptions.CalculusException;
import com.pchara.app.calculus.reporitories.CalculusRepository;
import com.pchara.app.calculus.services.CalculusService;

import org.springframework.beans.factory.annotation.Autowired;
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
    private CalculusRepository calculusRepository;
    
    @Autowired
    private CalculusService calculusService;
    
    @GetMapping("/sum/{a}/{b}")
    public ResponseEntity<Calculus> sum(@PathVariable("a") Double a, @PathVariable("b") Double b, Locale locale) throws CalculusException {
        return ResponseEntity.ok(calculusService.sum(a, b));
    }

    @GetMapping("/sub/{a}/{b}")
    public ResponseEntity<Calculus> sub(@PathVariable("a") Double a, @PathVariable("b") Double b, Locale locale) {
        return ResponseEntity.ok(calculusService.sub(a, b));
    }

    @GetMapping("/multiply/{a}/{b}")
    public ResponseEntity<Calculus> multiply(@PathVariable("a") Double a, @PathVariable("b") Double b, Locale locale) {
        return ResponseEntity.ok(calculusService.multiply(a, b));
    }
    @GetMapping("/division/{a}/{b}")
    public ResponseEntity<Calculus> division(@PathVariable("a") Double a, @PathVariable("b") Double b, Locale locale) {
        return ResponseEntity.ok(calculusService.division(a, b));
    }

    @GetMapping("/pow/{a}/{b}")
    public ResponseEntity<Calculus> pow(@PathVariable("a") Double a, @PathVariable("b") Double b, Locale locale) {
        return ResponseEntity.ok(calculusService.pow(a, b));
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