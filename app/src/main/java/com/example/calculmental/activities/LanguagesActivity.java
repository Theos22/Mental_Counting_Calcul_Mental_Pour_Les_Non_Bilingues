package com.example.calculmental.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculmental.R;

import java.util.Locale;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Switch;
import android.widget.Toast;

public class LanguagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        Button EnglishButton = findViewById(R.id.english_button);
        Button FrenchButton = findViewById(R.id.french_button);
        Button ItalianButton = findViewById(R.id.italian_button);
        Button GermanButton = findViewById(R.id.german_button);
        Button SpanishButton = findViewById(R.id.spanish_button);

        EnglishButton.setOnClickListener(view -> changeLanguage("en"));
        FrenchButton.setOnClickListener(view-> changeLanguage("fr"));
        ItalianButton.setOnClickListener(view-> changeLanguage("it"));
        GermanButton.setOnClickListener(view-> changeLanguage("ge"));
        SpanishButton.setOnClickListener(view-> changeLanguage("sp"));

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

    public void changeLanguage(String language) {
        switch (language) {
            case "en":
                break;
            case "fr":
                break;
            case "it":
                break;
            case "de":
                break;
            case "sp":
                break;
        }
    }

}
