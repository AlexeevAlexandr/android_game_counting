package com.example.myapplication.service;

import android.util.Log;

import com.example.myapplication.value.Value;

import java.util.Arrays;
import java.util.List;

public class ExpressionService {

    public static boolean checkExpression(String expression, String answer) {
        String[] arr = expression.split(" ");
        int a = 0, b = 0, c = 0;

        try {
            a = Integer.parseInt(arr[0]);
            b = Integer.parseInt(arr[2]);
            c = Integer.parseInt(answer);
        } catch (Exception e) {
            Log.d("ExpressionService", e.getMessage());
        }

        switch (arr[1]){
            case "+":
                return ((a + b) == c);
            case "-":
                return ((a - b) == c);
        }
        return false;
    }

    public static String getExpression() {
        String sign = getRandomSign();
        StringBuilder expression = new StringBuilder();
        int a, b;
        switch (sign) {
            case "-":
                a = getRandomNumber(Value.min, Value.max);
                b = getRandomNumber(a, Value.max);
                expression.append(b).append(" - ").append(a).append(" = ");
                break;
            case "+":
                a = getRandomNumber(Value.min, Value.max);
                b = getRandomNumber(Value.min, Value.max);
                expression.append(b).append(" + ").append(a).append(" = ");
                break;
        }
        return expression.toString();
    }

    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    private static String getRandomSign() {
        List<String> list = Arrays.asList("-", "+");
        return list.get((int)(Math.random() * 2));
    }
}
