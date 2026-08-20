package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button map,play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map=(Button) findViewById(R.id.maps);
        map.setOnClickListener(this);
        play=(Button)findViewById(R.id.playstore);
        play.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        android.content.Intent intent, chooser;
        if (v.getId()==R.id.maps){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:10.065206, 76.629128"));
            chooser = Intent.createChooser(intent,"Launch Maps");
            startActivity(chooser);
        }
        if (v.getId()==R.id.playstore){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=gov.nasa"));
            chooser = Intent.createChooser(intent,"Google play");
            startActivity(chooser);
        }
    }
}