package com.pchara.app.calculus;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculusService {

    private List<Calculus> history = new ArrayList<Calculus>();
    
    public Number sum(Number a, Number b) {
        if( !(a instanceof Number) || !(b instanceof Number) ) {
            throw new CalculusException("Invalid numbers");
        }
        Number result = a.doubleValue() + b.doubleValue();
        history.add(new Calculus(a, b, result, "sum"));
        return result;
    } 
    public Number sub(Number a, Number b) {
        Number result = a.doubleValue() - b.doubleValue();
        history.add(new Calculus(a, b, result, "sub"));
        return result;
    } 

    public Number multiply(Number a, Number b) {
        Number result = a.doubleValue() * b.doubleValue();
        history.add(new Calculus(a, b, result, "multiply"));
        return result;
    } 

    public Number division(Number a, Number b) {
        Number result = a.doubleValue() / b.doubleValue();
        history.add(new Calculus(a, b, result, "division"));
        return result;
    } 

    public Number pow(Number a, Number b) {
        Number result = Math.pow(a.doubleValue(),b.doubleValue());
        history.add(new Calculus(a, b, result, "pow"));
        return result;
    } 

    public List<Calculus> getHistory() {
        return history;
    }
}