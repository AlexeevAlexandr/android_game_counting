package com.example.myapplication.activity.multiplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import static com.example.myapplication.service.MultiplicationService.checkExpression;
import static com.example.myapplication.service.MultiplicationService.getExpression;

public class GameMultiplication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_multiplication);

        TextView alert = findViewById(R.id.alertMultiplication);
        TextView expression = findViewById(R.id.expressionMultiplication);
        TextView answer = findViewById(R.id.answerMultiplication);

        expression.setText(getExpression());

        Button checkButton = findViewById(R.id.checkMultiplication);
        checkButton.setOnClickListener(e -> {

            if (answer.getText().toString().isEmpty()) {
                alert.setText(getString(R.string.emptyAnswer));
            } else if (checkExpression(expression.getText().toString(), answer.getText().toString())) {
                expression.setText(getExpression());
                alert.setText("");
                answer.setText("");
            } else {
                answer.setText("");
                alert.setText(getString(R.string.incorrectAnswer));
            }
        });
    }
}
