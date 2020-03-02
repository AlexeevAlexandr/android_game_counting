package com.example.myapplication.activity.additionAndSubtraction;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.activity.score.ViewScoreActivity;
import com.example.myapplication.service.AdditionAndSubtractionService;
import com.example.myapplication.value.Value;

import java.util.Locale;

import static com.example.myapplication.value.Value.check;

public class GameAdditionAndSubtraction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_addition_and_subtraction);

        TextView alert = findViewById(R.id.alert);
        TextView expression = findViewById(R.id.expression);
        TextView answer = findViewById(R.id.answer);

        expression.setText(AdditionAndSubtractionService.getExpression());

        Button checkButton = findViewById(R.id.check);
        checkButton.setOnClickListener(e -> {

            if (answer.getText().toString().isEmpty()) {
                alert.setText(getString(R.string.emptyAnswer));
            } else if (AdditionAndSubtractionService.checkExpression(expression.getText().toString(), answer.getText().toString())) {
                expression.setText(AdditionAndSubtractionService.getExpression());
                alert.setText("");
                answer.setText("");
                Value.score ++;
            } else {
                answer.setText("");
                alert.setText(getString(R.string.incorrectAnswer));
            }
        });

        if (check) {
            Value.countDownTimer = new CountDownTimer(120000, 1000) {

                public void onTick(long time) {
                    EditText editText = findViewById(R.id.timer);
                    editText.setText(String.format(Locale.getDefault(),"%d:%d", ((time/1000)/60), ((time/1000)%60)));
                }

                public void onFinish() {
                    changeActivity();
                }
            }.start();
        }

    }

    private void changeActivity() {
        Intent intent = new Intent(this, ViewScoreActivity.class);
        startActivity(intent);
    }
}
