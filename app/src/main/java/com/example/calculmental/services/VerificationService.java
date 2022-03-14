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
        int result = 0;
        String operator = om.getOperator();

        switch (operator) {
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

        return result;
    }

}
