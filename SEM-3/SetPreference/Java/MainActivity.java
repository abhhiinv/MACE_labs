package com.example.firstpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText name,email;
    Button submit;
    String a,b;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.nameText);
        email=(EditText) findViewById(R.id.emailText);
        submit=(Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(this);

        sp=getSharedPreferences("theData",MODE_PRIVATE);
        if(sp.contains("Name")) name.setText(sp.getString("Name",""));
        if(sp.contains("Email")) email.setText(sp.getString("Email",""));
    }

    @Override
    public void onClick(View v){
        a=name.getText().toString();
        b=email.getText().toString();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Name",a);
        editor.putString("Email",b);
        editor.apply();

        Intent i = new Intent(this,SecondOne.class);
        startActivity(i);
    }
}