package com.pchara.app.calculus.entities;



public class CalculusResponse {
    private Number result;
    public CalculusResponse(Number result) {
        this.setResult(result);
    }
    public Number getResult() {
        return result;
    }
    public void setResult(Number result) {
        this.result = result;
    }
}
