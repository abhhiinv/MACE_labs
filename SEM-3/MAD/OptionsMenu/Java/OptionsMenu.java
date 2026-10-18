package com.example.options_menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.app.AlertDialog;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;

public class OptionsMenu extends AppCompatActivity {

    TextView l1, l2, l3, l4, l5, l6;
    int fact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.menu_demo);

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        l6 = findViewById(R.id.l6);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        MenuCompat.setGroupDividerEnabled(menu, true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.a1) {
            l1.setVisibility(View.VISIBLE);
            return true;
        } else if (id == R.id.a2) {
            l2.setVisibility(View.VISIBLE);
            return true;
        } else if (id == R.id.a3) {
            l3.setVisibility(View.VISIBLE);
            return true;
        } else if (id == R.id.a4) {
            l4.setVisibility(View.VISIBLE);
            return true;
        } else if (id == R.id.a5) {
            l5.setVisibility(View.VISIBLE);
            return true;
        } else if (id == R.id.a6) {
            l6.setVisibility(View.VISIBLE);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public int factorial(int n) {
        fact = 1;

        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }

    public void onClick(View view) {
        EditText input = findViewById(R.id.numberInput);
        String value = input.getText().toString().trim();

        if (value.isEmpty()) {
            input.setError("Enter a number");
            return;
        }

        int n;

        try {
            n = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            input.setError("Enter a valid number");
            return;
        }

        if (n < 0 || n > 12) {
            input.setError("Enter a number between 0 and 12");
            return;
        }

        fact = factorial(n);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(n + " Factorial is " + fact);
        builder.setPositiveButton("YES", null);
        builder.setNegativeButton("NO", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}