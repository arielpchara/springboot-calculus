package com.pchara.app.calculus.services;


import com.pchara.app.calculus.entities.Calculus;
import com.pchara.app.calculus.reporitories.CalculusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculusService {

    @Autowired
    CalculusRepository calculusRepository;
    
    public Calculus sum(Double a, Double b) {
        Double result = a + b;
        Calculus calc = calculusRepository.save(new Calculus(a, b, result, "sum"));
        return calc;
    } 
    public Calculus sub(Double a, Double b) {
        Double result = a - b;
        Calculus calc = calculusRepository.save(new Calculus(a, b, result, "sub"));
        return calc;
    } 

    public Calculus multiply(Double a, Double b) {
        Double result = a * b;
        Calculus calc = calculusRepository.save(new Calculus(a, b, result, "multiply"));
        return calc;
    } 

    public Calculus division(Double a, Double b) {
        Double result = a / b;
        Calculus calc = calculusRepository.save(new Calculus(a, b, result, "division"));
        return calc;
    } 

    public Calculus pow(Double a, Double b) {
        Double result = Math.pow(a,b);
        Calculus calc = calculusRepository.save(new Calculus(a, b, result, "pow"));
        return calc;
    }
}