package com.example.myapplication.activity.additionAndSubtraction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.service.SQLiteService;
import com.example.myapplication.value.Value;

import static com.example.myapplication.value.Value.bestScore;
import static com.example.myapplication.value.Value.countDownTimer;

public class AdditionAndSubtraction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition_and_subtraction);

        try {
            countDownTimer.cancel();
        } catch (Exception ignored){}

        try {
            bestScore = new SQLiteService(this).get();
            Log.i("AdditionAndSubtraction", "Best score from database: " + bestScore);
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

            Intent intent = new Intent(this, GameAdditionAndSubtraction.class);
            startActivity(intent);
        });
    }
}
