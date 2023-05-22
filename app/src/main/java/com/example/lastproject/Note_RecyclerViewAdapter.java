package com.example.lastproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Note_RecyclerViewAdapter extends RecyclerView.Adapter<Note_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<NoteModel> noteModels;

    public Note_RecyclerViewAdapter(Context context, ArrayList<NoteModel> noteModels, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.noteModels = noteModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public Note_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new Note_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Note_RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.tvTitle.setText(noteModels.get(position).getTitle());
        holder.tvDetail.setText(noteModels.get(position).getDetail());
        holder.tvImage.setImageResource(noteModels.get(position).getImage());

    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_row);

        btnIntentActivityB = (Button) findViewById(R.id.btnIntentActivityB);
        btnIntentActivityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }*/

    @Override
    public int getItemCount() {
        return noteModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle, tvDetail;
        ImageView tvImage;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.mTitleText);
            tvDetail = itemView.findViewById(R.id.mDetailText);
            tvImage = itemView.findViewById(R.id.imageView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
