package com.example.calculmental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button GameButton = findViewById(R.id.start_game_button);
        Button ScoreButton = findViewById(R.id.score_page_button);

        GameButton.setOnClickListener(view -> openGamePage());
        ScoreButton.setOnClickListener(view-> openScorePage());

    }

    private void openGamePage() {

        Intent openGamePage = new Intent(this, Game.class);
        startActivity(openGamePage);

    }

    private void openScorePage() {

        Intent openScorePage = new Intent(this, Score.class);
        startActivity(openScorePage);

    }

}