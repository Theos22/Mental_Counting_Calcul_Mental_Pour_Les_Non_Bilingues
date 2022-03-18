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

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button GameButton = findViewById(R.id.languages_button);
        Button ScoreButton = findViewById(R.id.sound_button);

        GameButton.setOnClickListener(view -> openLanguagesPage());
        ScoreButton.setOnClickListener(view-> openSoundsPage());

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

        int id = item.getItemId();

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

    private void openLanguagesPage() {

        Intent openLanguagesPage = new Intent(this, LanguagesActivity.class);
        startActivity(openLanguagesPage);

    }

    private void openSoundsPage() {

        Intent openSoundsPage = new Intent(this, SoundsActivity.class);
        startActivity(openSoundsPage);

    }

}
