package com.pchara.app.calculus.entities;

public class GroupByResult {
    private String operation;
    private Number occurrence;

    public GroupByResult(String operation, Number occurrence) {
        setOperation(operation);
        setOccurrence(occurrence);
    }
    
    public String getOperation() {
        return operation;
    };
    public Number getOccurrence() {
        return occurrence;
    };

    public void setOperation(String value) {
        operation = value;
    };
    public void setOccurrence(Number value) {
        occurrence = value;
    };
}
