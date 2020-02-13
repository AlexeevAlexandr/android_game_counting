package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.service.SQLiteService;
import com.example.myapplication.value.Value;

import java.util.Locale;

public class ViewScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_score);

        if (Value.bestScore < Value.score) {
            Value.bestScore = Value.score;
            new SQLiteService(this).update(Value.bestScore);
            Log.i("ViewScoreActivity","Saved new best score: " + Value.bestScore);
        }

        TextView bestScore = findViewById(R.id.bestScore);
        bestScore.setText(String.format(Locale.getDefault(), "Best score: %d", Value.bestScore));

        TextView score = findViewById(R.id.score);
        score.setText(String.format(Locale.getDefault(),"Score: %d", Value.score));

        Button restart = findViewById(R.id.restart);
        restart.setOnClickListener(e -> {
            Value.score = 0;
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        });
    }
}
