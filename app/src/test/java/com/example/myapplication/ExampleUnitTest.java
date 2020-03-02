package com.example.myapplication;

import com.example.myapplication.service.AdditionAndSubtractionService;
import com.example.myapplication.value.Value;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void getRandomSignTest() {
        Value.min = 0;
        Value.max = 10;
        String expression = AdditionAndSubtractionService.getExpression();
        Pattern pattern = Pattern.compile("(^\\w+\\s[+-]\\s\\w+\\s=)");
        Matcher matcher = pattern.matcher(expression);
        assertTrue(matcher.find());
    }

    @Test
    public void checkExpressionPlusTest() {
        String expression = "2 + 2 =";
        assertTrue(AdditionAndSubtractionService.checkExpression(expression, "4"));
    }

    @Test
    public void checkExpressionMinusTest() {
        String expression = "2 - 2 =";
        assertTrue(AdditionAndSubtractionService.checkExpression(expression, "0"));
    }
}