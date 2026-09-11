package com.example.adapterdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView l;
    Spinner s;
    String [] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l=(ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,days);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);
        s=(Spinner) findViewById(R.id.spin);
        ArrayAdapter<String> spinada = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,days);
        s.setAdapter(spinada);
        l.setOnItemClickListener(this::onItemClick);
    }
    public void onItemClick(AdapterView<?> parent, View v, int i, long id){
        Toast.makeText(this, days[i]+" "+i, Toast.LENGTH_LONG).show();
    }
}