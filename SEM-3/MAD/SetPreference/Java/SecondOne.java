package com.example.firstpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondOne extends AppCompatActivity implements View.OnClickListener{
    TextView first, second;
    Button back;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_one);
        back=(Button) findViewById(R.id.backButton);
        back.setOnClickListener(this);
        sp = getSharedPreferences("theData",MODE_PRIVATE);
        first =(TextView) findViewById(R.id.firstText);
        second=(TextView) findViewById(R.id.secondText);
        if(sp.contains("Name")) first.setText("Welcome "+sp.getString("Name",""));
        if(sp.contains("Email")) second.setText("Your Email is "+sp.getString("Email",""));
    }

    @Override
    public void onClick(View v){
        startActivity(new Intent(this, MainActivity.class));
    }
}