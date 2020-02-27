package com.minerleslie.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonMinus, buttonPlus, buttonTimes, buttonEqual, buttonCE, buttonDot;
    private String expression;
    private TextView expressionView;

    private String getAnswer(String expression) {
        Stack stack = new Stack();
        return new String();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonMinus = findViewById(R.id.button_minus);
        buttonPlus = findViewById(R.id.button_plus);
        buttonTimes = findViewById(R.id.button_times);
        buttonEqual = findViewById(R.id.button_equal);
        buttonCE = findViewById(R.id.button_ce);
        buttonDot = findViewById(R.id.button_dot);
        expressionView = findViewById(R.id.expressionView);
        expression = new String("");
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "0";
                expressionView.setText(expression);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "1";
                expressionView.setText(expression);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "2";
                expressionView.setText(expression);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "3";
                expressionView.setText(expression);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "4";
                expressionView.setText(expression);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "5";
                expressionView.setText(expression);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "6";
                expressionView.setText(expression);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "7";
                expressionView.setText(expression);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "8";
                expressionView.setText(expression);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "9";
                expressionView.setText(expression);
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + ".";
                expressionView.setText(expression);
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "-";
                expressionView.setText(expression);
            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "+";
                expressionView.setText(expression);
            }
        });
        buttonTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = expression + "*";
                expressionView.setText(expression);
            }
        });
        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = "";
                expressionView.setText(expression);
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //expression=getAnswer(expression);
                expressionView.setText(expression);
            }
        });
    }
}
