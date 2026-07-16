package com.example.factorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText input;
    TextView res;
    Button find;
    int v,fact=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find = (Button) findViewById(R.id.button);
        find.setOnClickListener(this);
    }
    public void onClick(View v){
        if(v.getId()==R.id.button){
            input=(EditText)findViewById(R.id.input);
            for(int i=2;i<=input;i++){
                fact*=i;
            }
        
        }
    }
}