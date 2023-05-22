package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<NoteModel> noteModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

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
            noteModels.add(new NoteModel(title[i], detail[i],image[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, ItemActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("TITLE", noteModels.get(position).getTitle());
        bundle.putString("DETAIL", noteModels.get(position).getDetail());
        bundle.putInt("IMAGE",noteModels.get(position).getImage());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}