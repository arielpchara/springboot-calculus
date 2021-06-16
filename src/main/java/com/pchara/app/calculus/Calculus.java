package com.pchara.app.calculus;

public class Calculus {
    public Number firstNumber;
    public Number secondNumber;
    public Number result;
    public String operation;
    Calculus(Number firstNumber, Number secondNumber, Number result, String operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
        this.operation = operation;
    }
}
