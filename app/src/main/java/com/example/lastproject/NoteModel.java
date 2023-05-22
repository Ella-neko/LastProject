package com.example.lastproject;

import java.util.ArrayList;

public class NoteModel {
    private final String title;
    private final String detail;
    private final int image;


    public NoteModel(String title, String detail,int image){
        this.title = title;
        this.detail = detail;
        this.image = image;
    }

    public String getTitle(){
        return title;
    }

    public String getDetail(){
        return detail;
    }

    public int getImage(){ return image; }

}
