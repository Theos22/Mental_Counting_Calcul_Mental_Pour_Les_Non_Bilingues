package com.example.calculmental.models;

public class OperationModel {

    private final int firstNumber;
    private final int secondNumber;
    private final String operator;


    public OperationModel(int f, String o, int s){
        this.firstNumber = f;
        this.operator = o;
        this.secondNumber = s;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public String getOperator() {
        return operator;
    }

}