package com.example.customtoast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater; // Added for custom toast
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText user, pwd;
    Button login;
    String u = "admin";
    String p = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Note: Ensure your button ID in activity_main.xml matches this exactly.
        // In your previous XML layout, it was "login_button"
        login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId() == R.id.login_button){
            user = (EditText) findViewById(R.id.username);
            pwd = (EditText) findViewById(R.id.password);

            String a = user.getText().toString();
            String b = pwd.getText().toString();
            Toast t1;
            if(a.equals(u) && b.equals(p)){
                LayoutInflater lay = getLayoutInflater();
                View appear = lay.inflate(R.layout.customtoast,(ViewGroup) findViewById(R.id.toast_id));
                t1 = Toast.makeText(this,"",Toast.LENGTH_LONG);
                t1.setView(appear);
                t1.show();
            } else {
                // --- DEFAULT TOAST FOR FAILURE ---
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_LONG).show();
            }
        }
    }
}