package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.activity.additionAndSubtraction.AdditionAndSubtraction;
import com.example.myapplication.activity.division.Division;
import com.example.myapplication.activity.multiplication.Multiplication;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button buttonAS = findViewById(R.id.buttonAS);
        Button buttonM = findViewById(R.id.buttonM);
        Button buttonD = findViewById(R.id.buttonD);

        buttonAS.setOnClickListener(e -> switchToAdditionAndSubtraction());
        buttonM.setOnClickListener(e -> switchToMultiplication());
        buttonD.setOnClickListener(e -> switchToDivision());

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

    private void switchToAdditionAndSubtraction() {
        Intent intent = new Intent(this, AdditionAndSubtraction.class);
        startActivity(intent);
    }

    private void switchToMultiplication() {
        Intent intent = new Intent(this, Multiplication.class);
        startActivity(intent);
    }

    private void switchToDivision() {
        Intent intent = new Intent(this, Division.class);
        startActivity(intent);
    }
}
