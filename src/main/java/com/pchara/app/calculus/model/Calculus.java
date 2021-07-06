package com.pchara.app.calculus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calculus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Number firstNumber;
    private Number secondNumber;
    private Number result;
    private String operation;

    public Calculus() {}

    public Calculus(Number firstNumber, Number secondNumber, Number result, String operation) {
        setFirstNumber(firstNumber);
        setSecondNumber(secondNumber);
        setResult(result);
        setOperation(operation);
    }

    public Number getFirstNumber() {
        return firstNumber;
    };
    public Number getSecondNumber() {
        return secondNumber;
    };
    public Number getResult() {
        return result;
    };
    public String getOperation() {
        return operation;
    };

    public void setFirstNumber(Number value) {
        firstNumber = value;
    };
    public void setSecondNumber(Number value) {
        secondNumber = value;
    };
    public void setResult(Number value) {
        result = value;
    };
    public void setOperation(String value) {
        operation = value;
    };

    
}
