package com.example.percentbg;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PercentBG extends AppCompatActivity implements TextWatcher{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.percent_bg);
        EditText percent = findViewById(R.id.percent);
        CheckBox cb = findViewById(R.id.check);
        ToggleButton tb = findViewById(R.id.togbtn);
        percent.addTextChangedListener(this);

        cb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Accepted", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Declined", Toast.LENGTH_SHORT).show();
            }
        });

        tb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            findViewById(R.id.main).setBackgroundColor(
                    isChecked
                            ? getColor(android.R.color.holo_blue_light)
                            : Color.parseColor("#93C572")
            );
        });
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    public void afterTextChanged(Editable editable) {
        String s = editable.toString();
        float num=0;
        if (!s.isEmpty()) {
            num = Float.parseFloat(s);
        }
        if (num > 100) {
            editable.replace(0,s.length(), "100");
        }
    }
}