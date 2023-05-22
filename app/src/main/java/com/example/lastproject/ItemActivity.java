package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    private Button btnIntentActivityB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("TITLE");
        String detail = bundle.getString("DETAIL");
        int image = bundle.getInt("IMAGE");
        TextView titleTextView = findViewById(R.id.mTitleText2);
        TextView detailTextView = findViewById(R.id.mDetailText2);
        ImageView imageView = findViewById(R.id.imageView);

        titleTextView.setText(title);
        detailTextView.setText(detail);
        imageView.setImageResource(image);

        btnIntentActivityB = (Button) findViewById(R.id.btnIntentActivityB);
        btnIntentActivityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ItemActivity.this,shopping1.class);
                startActivity(intent);
            }
        });


    }
}