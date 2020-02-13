package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.service.SQLiteService;
import com.example.myapplication.value.Value;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Value.countDownTimer.cancel();
        } catch (Exception ignored){}

        try {
            Value.bestScore = new SQLiteService(this).get();
            Log.i("MainActivity", "Best score from database: " + Value.bestScore);
        } catch (Exception ignored){}

        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(e -> {

            CheckBox checkBox = findViewById(R.id.checkBox);
            Value.check = checkBox.isChecked();

            EditText minValue = findViewById(R.id.minValue);
            EditText maxValue = findViewById(R.id.maxValue);
            Value.min = Integer.parseInt(minValue.getText().toString());
            Value.max = Integer.parseInt(maxValue.getText().toString());
            Value.score = 0;

            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        });

        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(e ->
                new AlertDialog.Builder(this).
                        setTitle(getString(R.string.app_name)).
                        setMessage(getString(R.string.confirm_exit)).
                        setPositiveButton(getString(R.string.yes), (a, b) -> {
                            moveTaskToBack(true);
                            finish();
                        })
                        .setNegativeButton(getString(R.string.no), (a, b) -> {
                        })
                .show());
    }
}
