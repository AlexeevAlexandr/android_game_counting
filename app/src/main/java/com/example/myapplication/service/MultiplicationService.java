package com.example.myapplication.service;

import android.util.Log;

import java.util.Locale;
import java.util.Random;

import static com.example.myapplication.value.Value.listCheckboxes;

public class MultiplicationService {

    public static boolean checkExpression(String expression, String answer){
        String[] arr = expression.split(" ");
        int a = 0, b = 0, c = 0;

        try {
            a = Integer.parseInt(arr[0]);
            b = Integer.parseInt(arr[2]);
            c = Integer.parseInt(answer);
        } catch (Exception e) {
            Log.d(DivisionService.class.getName(), e.getMessage());
        }
        return ((a * b) == c);
    }

    public static String getExpression() {
        int a = getRandomNumberFromListCheckboxes();
        int b = getRandomNumber();
        return String.format(Locale.getDefault(),"%d * %d = ", a, b);
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 10) + 1;
    }

    private static int getRandomNumberFromListCheckboxes() {
        return listCheckboxes.get(new Random().nextInt(listCheckboxes.size()));
    }
}
