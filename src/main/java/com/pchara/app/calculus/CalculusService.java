package com.pchara.app.calculus;


import org.springframework.stereotype.Service;

@Service
public class CalculusService {
    public Number sum(Number a, Number b) {
        return a.floatValue() + b.floatValue();
    } 
    public Number sub(Number a, Number b) {
        return a.floatValue() - b.floatValue();
    } 

    public Number multiply(Number a, Number b) {
        return a.floatValue() * b.floatValue();
    } 

    public Number division(Number a, Number b) {
        return a.floatValue() / b.floatValue();
    } 

    public Number pow(Number a, Number b) {
        return Math.pow(a.floatValue(),b.floatValue());
    } 
}