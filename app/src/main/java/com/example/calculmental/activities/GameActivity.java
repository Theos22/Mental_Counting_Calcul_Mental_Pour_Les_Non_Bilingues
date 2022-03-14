package com.example.calculmental.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import com.example.calculmental.R;
import com.example.calculmental.models.OperationModel;
import com.example.calculmental.models.exceptions.OperatorException;
import com.example.calculmental.services.OperationService;
import com.example.calculmental.services.VerificationService;

public class GameActivity extends AppCompatActivity {

    private EditText et;
    private OperationModel om;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        et = findViewById(R.id.answer);
        TextView twCurrentOperation = findViewById(R.id.current_operation);
        TextView twGoodAnswer = findViewById(R.id.good_answer);
        TextView twWrongAnswer = findViewById(R.id.wrong_answer);
        TextView twWarning = findViewById(R.id.warning);

        twGoodAnswer.setVisibility(View.INVISIBLE);
        twWrongAnswer.setVisibility(View.INVISIBLE);
        twWarning.setVisibility(View.INVISIBLE);

        OperationService os = new OperationService();
        om = os.generateRandomOperation();

        String operation = "(( " + om.getFirstNumber() + " " + om.getFirstOperator() + " " + om.getSecondNumber() + " ) "
                + om.getSecondOperator() + " " + om.getThirdNumber() + " ) "
                + om.getThirdOperator() + " " + om.getFourthNumber();
        twCurrentOperation.setText(operation);

        Button SubmitButton = findViewById(R.id.submit_button);
        Button MenuButton = findViewById(R.id.menu_button);
        Button NextButton = findViewById(R.id.next_button);

        SubmitButton.setOnClickListener(view -> {
            try {
                submit(twGoodAnswer, twWrongAnswer, twWarning);
            } catch(OperatorException e) {
                e.printStackTrace();
            }
        });

        MenuButton.setOnClickListener(view -> openMenuPage());
        NextButton.setOnClickListener(view -> newOperation());

    }

    private void openMenuPage() {

        Intent openMenuPage = new Intent(this, MainActivity.class);
        startActivity(openMenuPage);

    }

    private void newOperation() {

        Intent openGamePage = new Intent(this, GameActivity.class);
        startActivity(openGamePage);

    }

    private void submit(TextView twGoodAnswer, TextView twWrongAnswer, TextView twWarning) throws OperatorException {

        VerificationService vs = new VerificationService();
        String answer = et.getText().toString();

        if(answer.equals("")) {
            twGoodAnswer.setVisibility(View.INVISIBLE);
            twWrongAnswer.setVisibility(View.INVISIBLE);
            twWarning.setVisibility(View.VISIBLE);
        } else {
            if(vs.verifyEquality(om, Integer.parseInt(answer))){
                twGoodAnswer.setVisibility(View.VISIBLE);
                twWrongAnswer.setVisibility(View.INVISIBLE);
            } else {
                twGoodAnswer.setVisibility(View.INVISIBLE);
                twWrongAnswer.setVisibility(View.VISIBLE);
            }
            twWarning.setVisibility(View.INVISIBLE);
        }

    }

}
