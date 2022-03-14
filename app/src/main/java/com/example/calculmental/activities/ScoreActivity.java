package com.example.calculmental.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.calculmental.R;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button MenuButton = findViewById(R.id.menu_button);
        Button ResetButton = findViewById(R.id.reset_button);

        MenuButton.setOnClickListener(view -> previousPage());
        ResetButton.setOnClickListener(view -> reset());
    }

    private void previousPage(){
        finish();
    }

    private void reset() { /* accès à la BDD */ }

}
