package com.example.calculmental.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        Button NextButton = findViewById(R.id.next_button);

        SubmitButton.setOnClickListener(view -> {
            try {
                submit(twGoodAnswer, twWrongAnswer, twWarning);
            } catch(OperatorException e) {
                e.printStackTrace();
            }
        });

        NextButton.setOnClickListener(view -> newOperation());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id  = item.getItemId();

        switch (id) {
            case R.id.menu_to_main:
                Intent intentMain = new Intent(this, MainActivity.class);
                startActivity(intentMain);
                break;
            case R.id. menu_to_game:
                Intent intentGame = new Intent(this, GameActivity.class);
                startActivity(intentGame);
                break;
            case R.id. menu_to_score:
                Intent intentScore = new Intent(this, ScoreActivity.class);
                startActivity(intentScore);
                break;
        }
        return super.onOptionsItemSelected(item);

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
