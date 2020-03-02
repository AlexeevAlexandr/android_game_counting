package com.example.myapplication.activity.division;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

import static com.example.myapplication.value.Value.listCheckboxes;

public class Division extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.division);

        Button start = findViewById(R.id.startDivision);
        start.setOnClickListener(e -> {
            checkCheckboxes();
            changeActivity();
        });
    }

    private void checkCheckboxes(){
        listCheckboxes = new ArrayList<>();
        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        if (checkBox1.isChecked()){ listCheckboxes.add(1); }
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        if (checkBox2.isChecked()){ listCheckboxes.add(2); }
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        if (checkBox3.isChecked()){ listCheckboxes.add(3); }
        CheckBox checkBox4 = findViewById(R.id.checkBox4);
        if (checkBox4.isChecked()){ listCheckboxes.add(4); }
        CheckBox checkBox5 = findViewById(R.id.checkBox5);
        if (checkBox5.isChecked()){ listCheckboxes.add(4); }
        CheckBox checkBox6 = findViewById(R.id.checkBox6);
        if (checkBox6.isChecked()){ listCheckboxes.add(6); }
        CheckBox checkBox7 = findViewById(R.id.checkBox7);
        if (checkBox7.isChecked()){ listCheckboxes.add(7); }
        CheckBox checkBox8 = findViewById(R.id.checkBox8);
        if (checkBox8.isChecked()){ listCheckboxes.add(8); }
        CheckBox checkBox9 = findViewById(R.id.checkBox9);
        if (checkBox9.isChecked()){ listCheckboxes.add(9); }
    }

    private void changeActivity() {
        Intent intent = new Intent(this, GameDivision.class);
        startActivity(intent);
    }
}
