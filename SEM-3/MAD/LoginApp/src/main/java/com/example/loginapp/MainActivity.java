package com.example.loginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText user,pwd;
    Button login;
    String u="admin";
    String p="123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button) findViewById(R.id.loginButton);
        login.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId()==R.id.loginButton){
            user=(EditText) findViewById(R.id.username);
            pwd=(EditText) findViewById(R.id.password);
            String a=user.getText().toString();
            String b=pwd.getText().toString();
            if(a.equals(u) && b.equals(p)){
                Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Invalid Login",Toast.LENGTH_LONG).show();
            }
        }
    }
}