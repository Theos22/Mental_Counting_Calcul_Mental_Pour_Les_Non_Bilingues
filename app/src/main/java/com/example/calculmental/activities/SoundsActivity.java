package com.example.calculmental.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculmental.R;

public class SoundsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);

        Button SoundOnButton = findViewById(R.id.sound_on_button);
        Button SoundOffButton = findViewById(R.id.sound_off_button);

        SoundOnButton.setOnClickListener(view -> soundOn());
        SoundOffButton.setOnClickListener(view-> soundOff());

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

    private void soundOn() {

    }

    private void soundOff() {

    }
}
