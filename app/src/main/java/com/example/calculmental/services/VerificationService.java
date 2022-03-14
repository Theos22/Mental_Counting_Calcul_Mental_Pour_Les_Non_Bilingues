package com.example.calculmental.services;

import com.example.calculmental.models.OperationModel;
import com.example.calculmental.models.exceptions.OperatorException;

public class VerificationService {

    public boolean verifyEquality(OperationModel om, int userAnswer) throws OperatorException {
        int operationResult = operationResult(om);
        return userAnswer == operationResult;
    }

    public int operationResult(OperationModel om) throws OperatorException {
        int firstNumber = om.getFirstNumber();
        int secondNumber = om.getSecondNumber();
        int thirdNumber = om.getThirdNumber();
        int fourthNumber = om.getFourthNumber();
        int result = 0;
        String firstOperator = om.getFirstOperator();
        String secondOperator = om.getSecondOperator();
        String thirdOperator = om.getThirdOperator();

        switch (firstOperator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            default:
                throw new OperatorException("@string/invalid_operator");
        }

        switch (secondOperator) {
            case "+":
                result += thirdNumber;
                break;
            case "-":
                result -= thirdNumber;
                break;
            case "*":
                result *= thirdNumber;
                break;
            default:
                throw new OperatorException("@string/invalid_operator");
        }

        switch (thirdOperator) {
            case "+":
                result += fourthNumber;
                break;
            case "-":
                result -= fourthNumber;
                break;
            case "*":
                result *= fourthNumber;
                break;
            default:
                throw new OperatorException("@string/invalid_operator");
        }

        return result;
    }

}
