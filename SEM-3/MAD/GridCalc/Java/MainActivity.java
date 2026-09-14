package com.example.gridcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView disp;
    private StringBuilder currentInput = new StringBuilder();
    private double operand1 = Double.NaN;
    private String pendingOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disp = findViewById(R.id.tvDisplay);

        // Operator and Action buttons
        findViewById(R.id.div).setOnClickListener(this);
        findViewById(R.id.mul).setOnClickListener(this);
        findViewById(R.id.min).setOnClickListener(this);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.del).setOnClickListener(this);
        findViewById(R.id.ac).setOnClickListener(this);
        findViewById(R.id.dot).setOnClickListener(this);
        findViewById(R.id.eq).setOnClickListener(this);

        // Numeric buttons
        findViewById(R.id.b0).setOnClickListener(this);
        findViewById(R.id.b1).setOnClickListener(this);
        findViewById(R.id.b2).setOnClickListener(this);
        findViewById(R.id.b3).setOnClickListener(this);
        findViewById(R.id.b4).setOnClickListener(this);
        findViewById(R.id.b5).setOnClickListener(this);
        findViewById(R.id.b6).setOnClickListener(this);
        findViewById(R.id.b7).setOnClickListener(this);
        findViewById(R.id.b8).setOnClickListener(this);
        findViewById(R.id.b9).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.b0) appendNumber("0");
        else if (id == R.id.b1) appendNumber("1");
        else if (id == R.id.b2) appendNumber("2");
        else if (id == R.id.b3) appendNumber("3");
        else if (id == R.id.b4) appendNumber("4");
        else if (id == R.id.b5) appendNumber("5");
        else if (id == R.id.b6) appendNumber("6");
        else if (id == R.id.b7) appendNumber("7");
        else if (id == R.id.b8) appendNumber("8");
        else if (id == R.id.b9) appendNumber("9");
        else if (id == R.id.dot) appendDot();
        else if (id == R.id.ac) clearAll();
        else if (id == R.id.del) deleteLast();
        else if (id == R.id.add || id == R.id.min || id == R.id.mul || id == R.id.div) {
            Button btn = (Button) v;
            handleOperator(btn.getText().toString());
        } else if (id == R.id.eq) {
            calculateResult();
        }
    }

    private void appendNumber(String num) {
        if (currentInput.toString().equals("0")) {
            currentInput.setLength(0);
        }
        currentInput.append(num);
        disp.setText(currentInput.toString());
    }

    private void appendDot() {
        if (!currentInput.toString().contains(".")) {
            if (currentInput.length() == 0) {
                currentInput.append("0");
            }
            currentInput.append(".");
            disp.setText(currentInput.toString());
        }
    }

    private void clearAll() {
        currentInput.setLength(0);
        operand1 = Double.NaN;
        pendingOperation = "";
        disp.setText("0");
    }

    private void deleteLast() {
        if (currentInput.length() > 0) {
            currentInput.deleteCharAt(currentInput.length() - 1);
            if (currentInput.length() == 0) {
                disp.setText("0");
            } else {
                disp.setText(currentInput.toString());
            }
        }
    }

    private void handleOperator(String op) {
        if (currentInput.length() > 0) {
            if (!Double.isNaN(operand1)) {
                calculateResult();
            }
            operand1 = Double.parseDouble(currentInput.toString());
            pendingOperation = op;
            currentInput.setLength(0);
        } else if (!Double.isNaN(operand1)) {
            pendingOperation = op;
        }
    }

    private void calculateResult() {
        if (!Double.isNaN(operand1) && currentInput.length() > 0) {
            double operand2 = Double.parseDouble(currentInput.toString());
            double result = 0;

            switch (pendingOperation) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        disp.setText("Error");
                        clearAll();
                        return;
                    }
                    break;
            }

            // Clean format for whole numbers
            if (result == (long) result) {
                disp.setText(String.valueOf((long) result));
            } else {
                disp.setText(String.valueOf(result));
            }
            currentInput.setLength(0);
            currentInput.append(disp.getText().toString());
            operand1 = Double.NaN;
            pendingOperation = "";
        }
    }
}