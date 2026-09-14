package com.example.adapterimage;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RareGems extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ImageView imageView;
    String[] gemNames = {"Pato", "Totti", "Villa", "Cole", "Hulk"};
    int[] gemImages = {
            R.drawable.pato1,
            R.drawable.totti2,
            R.drawable.villa3,
            R.drawable.cole4,
            R.drawable.hulk5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.rare_gems);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.gems_list);
        imageView = findViewById(R.id.display_image);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_centered, gemNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        imageView.setImageResource(gemImages[position]);
    }
}