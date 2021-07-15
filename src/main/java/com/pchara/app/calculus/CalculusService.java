package com.pchara.app.calculus;


import com.pchara.app.calculus.model.Calculus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculusService {

    @Autowired
    CalculusRepository calculusRepository;

    private List<Calculus> history = new ArrayList<Calculus>();
    
    public Double sum(Double a, Double b) {
        if( !(a instanceof Double) || !(b instanceof Double) ) {
            throw new CalculusException("Invalid numbers");
        }
        Double result = a + b;
        calculusRepository.save(new Calculus(a, b, result, "sum"));
        return result;
    } 
    public Double sub(Double a, Double b) {
        Double result = a - b;
        calculusRepository.save(new Calculus(a, b, result, "sub"));
        return result;
    } 

    public Double multiply(Double a, Double b) {
        Double result = a * b;
        calculusRepository.save(new Calculus(a, b, result, "multiply"));
        return result;
    } 

    public Double division(Double a, Double b) {
        Double result = a / b;
        calculusRepository.save(new Calculus(a, b, result, "division"));
        return result;
    } 

    public Double pow(Double a, Double b) {
        Double result = Math.pow(a,b);
        calculusRepository.save(new Calculus(a, b, result, "pow"));
        return result;
    } 

    public List<Calculus> getHistory() {
        return history;
    }
}