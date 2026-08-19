package com.example.reglogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView ivAvatar;
    private TextView tvDisplayName, tvDisplayEmail, tvDisplayGender;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ivAvatar        = findViewById(R.id.iv_avatar);
        tvDisplayName   = findViewById(R.id.tv_display_name);
        tvDisplayEmail  = findViewById(R.id.tv_display_email);
        tvDisplayGender = findViewById(R.id.tv_display_gender);
        btnLogout       = findViewById(R.id.btn_logout);

        // Retrieve data passed from LoginRegisterActivity
        Intent intent = getIntent();
        String name   = intent.getStringExtra("name");
        String email  = intent.getStringExtra("email");
        String gender = intent.getStringExtra("gender"); // "Male" or "Female"

        tvDisplayName.setText(name);
        tvDisplayEmail.setText(email);
        tvDisplayGender.setText(gender);

        // Set avatar based on gender
        // Rename your drawables to avatar_male and avatar_female in res/drawable/
        if ("Male".equalsIgnoreCase(gender)) {
            ivAvatar.setImageResource(R.drawable.male);
        } else {
            ivAvatar.setImageResource(R.drawable.female);
        }

        btnLogout.setOnClickListener(v -> {
            // Go back to login screen and clear the back stack
            Intent logoutIntent = new Intent(this, LoginRegisterActivity.class);
            logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(logoutIntent);
            finish();
        });
    }
}