package com.example.calculmental.services;

import java.util.Random;

import com.example.calculmental.models.OperationModel;

public class OperationService {

    public OperationModel generateRandomOperation(){

        int firstNumber;
        String firstOperator = firstOperator();
        int secondNumber;
        String secondOperator = otherOperator();
        int thirdNumber;
        String thirdOperator = otherOperator();
        int fourthNumber;

        // First Number and Second Number
        if(firstOperator.equals("/")) {
            int div = randomInt(19);
            firstNumber = div * randomInt(19);;
            secondNumber = div;
        } else {
            firstNumber = randomInt(99);
            secondNumber = randomInt(99);
        }

        // Third Number
        thirdNumber = randomInt(99);

        // Fourth Number
        fourthNumber = randomInt(99);

        return new OperationModel(
                firstNumber, firstOperator,
                secondNumber, secondOperator,
                thirdNumber, thirdOperator,
                fourthNumber);
    }

    private int randomInt(int max){
        Random random = new Random();
        return random.nextInt(max) + 1;
    }

    private String firstOperator(){
        String[] operators = {"+", "-", "*", "/"};
        int arrayCell = new Random().nextInt(operators.length);

        return operators[arrayCell];
    }

    private String otherOperator(){
        String[] operators = {"+", "-", "*"};
        int arrayCell = new Random().nextInt(operators.length);

        return operators[arrayCell];
    }

}
