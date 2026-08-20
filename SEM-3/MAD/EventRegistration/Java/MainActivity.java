package com.example.eventregistration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail;
    private RadioGroup rgCategory;
    private CheckBox cbAndroid, cbAiMl, cbCyber;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        rgCategory = findViewById(R.id.rgCategory);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbAiMl = findViewById(R.id.cbAiMl);
        cbCyber = findViewById(R.id.cbCyber);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter name and email", Toast.LENGTH_SHORT).show();
                return;
            }

            // Get Category
            int selectedId = rgCategory.getCheckedRadioButtonId();
            RadioButton selectedRb = findViewById(selectedId);
            String category = selectedRb != null ? selectedRb.getText().toString() : "Not Selected";

            // Get Workshops
            StringBuilder workshops = new StringBuilder();
            if (cbAndroid.isChecked()) workshops.append("Android Development\n");
            if (cbAiMl.isChecked()) workshops.append("AI & ML\n");
            if (cbCyber.isChecked()) workshops.append("Cybersecurity\n");

            if (workshops.length() == 0) workshops.append("None");

            // Save data to SharedPreferences as requested
            SharedPreferences sharedPreferences = getSharedPreferences("RegistrationPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Name", name);
            editor.putString("Email", email);
            editor.putString("Category", category);
            editor.putString("Workshops", workshops.toString().trim());
            editor.apply();

            // Navigate to Activity 2
            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
            startActivity(intent);
        });
    }
}