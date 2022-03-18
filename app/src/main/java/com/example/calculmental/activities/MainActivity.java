package com.example.calculmental.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.example.calculmental.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button GameButton = findViewById(R.id.start_game_button);
        Button ScoreButton = findViewById(R.id.score_page_button);
        Button SettingsButton = findViewById(R.id.settings_page_button);

        GameButton.setOnClickListener(view -> openGamePage());
        ScoreButton.setOnClickListener(view-> openScorePage());
        SettingsButton.setOnClickListener(view-> openSettingsPage());

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

    private void openGamePage() {

        Intent openGamePage = new Intent(this, GameActivity.class);
        startActivity(openGamePage);

    }

    private void openScorePage() {

        Intent openScorePage = new Intent(this, ScoreActivity.class);
        startActivity(openScorePage);

    }

    private void openSettingsPage() {

        Intent openSettingsPage = new Intent(this, SettingsActivity.class);
        startActivity(openSettingsPage);

    }

}