package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.service.ExpressionService;
import com.example.myapplication.value.Value;

import java.util.Locale;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        TextView textView = findViewById(R.id.expression);
        TextView alert = findViewById(R.id.alert);
        TextView answer = findViewById(R.id.answer);

        textView.setText(ExpressionService.getExpression());

        Button checkButton = findViewById(R.id.check);
        checkButton.setOnClickListener(e -> {

            if (answer.getText().toString().isEmpty()) {
                alert.setText(getString(R.string.emptyAnswer));
            } else if (ExpressionService.checkExpression(textView.getText().toString(), answer.getText().toString())) {
                textView.setText(ExpressionService.getExpression());
                alert.setText("");
                answer.setText("");
                Value.score ++;
            } else {
                alert.setText(getString(R.string.incorrectAnswer));
            }
        });

        if (Value.check) {
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
