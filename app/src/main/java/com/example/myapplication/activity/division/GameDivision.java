package com.example.myapplication.activity.division;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import static com.example.myapplication.service.DivisionService.checkExpression;
import static com.example.myapplication.service.DivisionService.getExpression;

public class GameDivision extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_division);

        TextView alert = findViewById(R.id.alertDivision);
        TextView expression = findViewById(R.id.expressionDivision);
        TextView answer = findViewById(R.id.answerDivision);

        expression.setText(getExpression());

        Button checkButton = findViewById(R.id.checkDivision);
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
