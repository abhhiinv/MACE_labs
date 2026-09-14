package com.example.framelayout;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HappyBirthday extends AppCompatActivity {

    private boolean show = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.happy_birthday);
        
        View mainView = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View layoutHbdContainer = findViewById(R.id.layoutHbdContainer);
        ImageView imageViewDontClick = findViewById(R.id.imageViewDontClick);
        TextView textViewMessage = findViewById(R.id.textViewMessage);

        // Load custom typeface from assets and apply it to the TextView
        Typeface myFont = Typeface.createFromAsset(getAssets(), "font/Sofia-Regular.ttf");
        textViewMessage.setTypeface(myFont);

        View.OnClickListener toggleListener = v -> {
            show = !show;
            if (show) {
                imageViewDontClick.setVisibility(View.GONE);
                layoutHbdContainer.setVisibility(View.VISIBLE);
            } else {
                imageViewDontClick.setVisibility(View.VISIBLE);
                layoutHbdContainer.setVisibility(View.GONE);
            }
        };

        imageViewDontClick.setOnClickListener(toggleListener);
        layoutHbdContainer.setOnClickListener(toggleListener);
    }
}