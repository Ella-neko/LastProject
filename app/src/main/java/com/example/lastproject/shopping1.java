package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/*public class shopping1 extends AppCompatActivity {

    private Button buttom123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping1);

        buttom123 = (Button) findViewById(R.id.buttom123);
        buttom123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(shopping1.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}*/

public class shopping1 extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<NoteModel> noteModels = new ArrayList<>();
    private Button buttom123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping1);

        buttom123 = (Button) findViewById(R.id.buttom123);
        buttom123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(shopping1.this,MainActivity.class);
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView = findViewById(R.id.recyclerview2);

        setUpNoteModels();

        Note_RecyclerViewAdapter adapter = new Note_RecyclerViewAdapter(this, noteModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpNoteModels(){
        String[] title = getResources().getStringArray(R.array.note_title_text);
        String[] detail = getResources().getStringArray(R.array.note_detail_text);
        int[] image = {R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2};

        for (int i = 0;i < title.length; i++){
            noteModels.add(new NoteModel(title[i], detail[i], image[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(shopping1.this, ItemActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("TITLE", noteModels.get(position).getTitle());
        bundle.putString("DETAIL", noteModels.get(position).getDetail());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}