package com.example.calculmental;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuInflater;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button previousButton = findViewById(R.id.menu_button);
        previousButton.setOnClickListener(view -> previousPage());
    }

    private void previousPage(){
        finish();
    }

}
