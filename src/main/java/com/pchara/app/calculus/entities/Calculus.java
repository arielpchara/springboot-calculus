package com.pchara.app.calculus.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Calculus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double firstNumber;
    private Double secondNumber;
    private Double result;
    private String operation;

    public Calculus() {}

    public Calculus(Double firstNumber, Double secondNumber, Double result, String operation) {
        setFirstNumber(firstNumber);
        setSecondNumber(secondNumber);
        setResult(result);
        setOperation(operation);
    }

    public Double getFirstNumber() {
        return firstNumber;
    };
    public Double getSecondNumber() {
        return secondNumber;
    };
    public Double getResult() {
        return result;
    };
    public String getOperation() {
        return operation;
    };

    public void setFirstNumber(Double value) {
        firstNumber = value;
    };
    public void setSecondNumber(Double value) {
        secondNumber = value;
    };
    public void setResult(Double value) {
        result = value;
    };
    public void setOperation(String value) {
        operation = value;
    };

    
}
