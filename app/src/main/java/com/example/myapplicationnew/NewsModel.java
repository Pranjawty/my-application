package com.example.myapplicationnew;

import java.io.Serializable;

public class NewsModel implements Serializable {

    private String sdate,title,text,category,tags;
    private  int image,sl;

    public NewsModel(int sl, String sdate, String title, String text, int image, String category, String tags) {
        this.sdate = sdate;
        this.title = title;
        this.text = text;
        this.image = image;
        this.category = category;
        this.tags = tags;
    }

    public NewsModel(String sdate, String title, String text, int image, String category, String tags) {
        this.sdate = sdate;
        this.title = title;
        this.text = text;
        this.image = image;
        this.category = category;
        this.tags = tags;
    }

    public int getSl() {
        return sl;
    }

    public String getSdate() {
        return sdate;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public String getTags() {
        return tags;
    }
}
