package com.example.calculmental.services;

import java.util.Random;

import com.example.calculmental.models.OperationModel;

public class OperationService {

    public OperationModel generateRandomOperation(){
        int firstNumber = randomInt();
        int secondNumber = randomInt();
        String operator = randomOperator();
        if(operator.equals("/")) {
            int div = randomInt();
            firstNumber *= div;
            secondNumber = div;
        }
        if(operator.equals("-")) {
            if(firstNumber < secondNumber) {
                int save = firstNumber;
                firstNumber = secondNumber;
                secondNumber = save;
            }
        }
        return new OperationModel(firstNumber, operator, secondNumber);
    }

    private int randomInt(){
        int max = 99;
        Random random = new Random();
        return random.nextInt(max) + 1;
    }

    private String randomOperator(){
        String[] operators = {"+", "-", "*", "/"};
        int arrayCell = new Random().nextInt(operators.length);

        return operators[arrayCell];
    }

}
