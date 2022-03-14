package com.example.calculmental.models;

public class OperationModel {

    private final int firstNumber;
    private final int secondNumber;
    private final int thirdNumber;
    private final int fourthNumber;
    private final String firstOperator;
    private final String secondOperator;
    private final String thirdOperator;


    public OperationModel(int n1, String o1, int n2, String o2, int n3, String o3, int n4){
        this.firstNumber = n1;
        this.firstOperator = o1;
        this.secondNumber = n2;
        this.secondOperator = o2;
        this.thirdNumber = n3;
        this.thirdOperator = o3;
        this.fourthNumber = n4;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

    public int getFourthNumber() {
        return fourthNumber;
    }

    public String getFirstOperator() {
        return firstOperator;
    }

    public String getSecondOperator() {
        return secondOperator;
    }

    public String getThirdOperator() {
        return thirdOperator;
    }

}