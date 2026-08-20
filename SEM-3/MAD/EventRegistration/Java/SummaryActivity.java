package com.example.eventregistration;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private TextView tvSummaryDetails;
    private Button btnBackToEdit, btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvSummaryDetails = findViewById(R.id.tvSummaryDetails);
        btnBackToEdit = findViewById(R.id.btnBackToEdit);
        btnConfirm = findViewById(R.id.btnConfirm);

        // Retrieve data passed via SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("RegistrationPrefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("Name", "N/A");
        String email = sharedPreferences.getString("Email", "N/A");
        String category = sharedPreferences.getString("Category", "N/A");
        String workshops = sharedPreferences.getString("Workshops", "N/A");

        // Format and display the summary
        String summaryText = "Name: " + name + "\n\n" +
                "Email: " + email + "\n\n" +
                "Category: " + category + "\n\n" +
                "Workshops Selected:\n" + workshops;

        tvSummaryDetails.setText(summaryText);

        // Back to Edit navigates back to MainActivity to facilitate modification
        btnBackToEdit.setOnClickListener(v -> finish()); // Closes this activity, resuming MainActivity

        // Confirm Registration displays Custom Toast
        btnConfirm.setOnClickListener(v -> showCustomToast());
    }

    private void showCustomToast() {
        // Inflate the custom toast layout
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout, findViewById(R.id.custom_toast_container));

        TextView text = layout.findViewById(R.id.text);
        text.setText("Registration Confirmed");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}