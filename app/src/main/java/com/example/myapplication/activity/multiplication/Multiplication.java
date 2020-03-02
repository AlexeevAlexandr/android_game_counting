package com.example.myapplication.activity.multiplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.activity.multiplication.GameMultiplication;

import java.util.ArrayList;

import static com.example.myapplication.value.Value.listCheckboxes;

public class Multiplication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplication);

        Button start = findViewById(R.id.startMultiplicationGame);
        start.setOnClickListener(e -> {
            checkCheckboxes();
            changeActivity();
        });
    }

    private void checkCheckboxes(){
        listCheckboxes = new ArrayList<>();
        CheckBox checkBox1 = findViewById(R.id.checkBoxMultiplication1);
        if (checkBox1.isChecked()){ listCheckboxes.add(1); }
        CheckBox checkBox2 = findViewById(R.id.checkBoxMultiplication2);
        if (checkBox2.isChecked()){ listCheckboxes.add(2); }
        CheckBox checkBox3 = findViewById(R.id.checkBoxMultiplication3);
        if (checkBox3.isChecked()){ listCheckboxes.add(3); }
        CheckBox checkBox4 = findViewById(R.id.checkBoxMultiplication4);
        if (checkBox4.isChecked()){ listCheckboxes.add(4); }
        CheckBox checkBox5 = findViewById(R.id.checkBoxMultiplication5);
        if (checkBox5.isChecked()){ listCheckboxes.add(4); }
        CheckBox checkBox6 = findViewById(R.id.checkBoxMultiplication6);
        if (checkBox6.isChecked()){ listCheckboxes.add(6); }
        CheckBox checkBox7 = findViewById(R.id.checkBoxMultiplication7);
        if (checkBox7.isChecked()){ listCheckboxes.add(7); }
        CheckBox checkBox8 = findViewById(R.id.checkBoxMultiplication8);
        if (checkBox8.isChecked()){ listCheckboxes.add(8); }
        CheckBox checkBox9 = findViewById(R.id.checkBoxMultiplication9);
        if (checkBox9.isChecked()){ listCheckboxes.add(9); }
    }

    private void changeActivity() {
        Intent intent = new Intent(this, GameMultiplication.class);
        startActivity(intent);
    }
}
