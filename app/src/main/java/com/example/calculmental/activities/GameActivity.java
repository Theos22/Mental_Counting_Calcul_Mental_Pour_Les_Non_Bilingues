package com.example.calculmental.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
        TextView tw = findViewById(R.id.current_operation);

        OperationService os = new OperationService();
        om = os.generateRandomOperation();

        String operation = om.getFirstNumber() + "   " + om.getOperator() + "   " + om.getSecondNumber();
        tw.setText(operation);

        Button SubmitButton = findViewById(R.id.submit_button);
        Button MenuButton = findViewById(R.id.menu_button);
        Button NextButton = findViewById(R.id.next_button);

        SubmitButton.setOnClickListener(view -> {
            try {
                submit();
            } catch(OperatorException e) {
                e.printStackTrace();
            }
        });

        MenuButton.setOnClickListener(view -> finish());
        NextButton.setOnClickListener(view -> newOperation());

    }

    private void newOperation() {

        TextView twGoodAnswer = findViewById(R.id.good_answer);
        twGoodAnswer.setVisibility(View.INVISIBLE);

        TextView twWrongAnswer = findViewById(R.id.wrong_answer);
        twWrongAnswer.setVisibility(View.INVISIBLE);

        Intent openGamePage = new Intent(this, GameActivity.class);
        startActivity(openGamePage);

    }

    private void submit() throws OperatorException {

        String answer = et.getText().toString();

        if(answer.equals("")) {
            TextView tw = findViewById(R.id.warning);
            tw.setVisibility(View.VISIBLE);
        } else {
            int answerAsAnInt = Integer.parseInt(answer);
            verification(answerAsAnInt);
        }

    }

    private void verification(int result) throws OperatorException {

        VerificationService vs = new VerificationService();

        if(vs.verifyEquality(om, result)){
            TextView tw = findViewById(R.id.good_answer);
            tw.setVisibility(View.VISIBLE);
        } else {
            TextView tw = findViewById(R.id.wrong_answer);
            tw.setVisibility(View.VISIBLE);
        }

    }

}
