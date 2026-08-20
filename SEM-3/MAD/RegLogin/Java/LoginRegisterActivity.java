package com.example.reglogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginRegisterActivity extends AppCompatActivity {

    private EditText etName, etEmail;
    private RadioGroup rgGender;
    private Button btnLogin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        etName   = findViewById(R.id.et_name);
        etEmail  = findViewById(R.id.et_email);
        rgGender = findViewById(R.id.rg_gender);
        btnLogin  = findViewById(R.id.btn_login);
        btnSignup = findViewById(R.id.btn_signup);

        btnLogin.setOnClickListener(v -> handleSubmit("login"));
        btnSignup.setOnClickListener(v -> handleSubmit("signup"));
    }

    private void handleSubmit(String mode) {
        String name  = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        // Basic validation
        if (name.isEmpty()) {
            etName.setError("Name is required");
            return;
        }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email");
            return;
        }

        int selectedId = rgGender.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selected = findViewById(selectedId);
        String gender = selected.getText().toString(); // "Male" or "Female"

        // Pass name, email, gender to ProfileActivity
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("gender", gender);
        startActivity(intent);
    }
}