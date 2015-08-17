package com.dejiitaru.bitchnel.model;

import java.util.ArrayList;

/**
 * Created by Usuario on 8/8/2015.
 */
public class MovieChecked {

    private String title, thumbnailUrl;
    private int year;
    private double rating;
    private boolean checked = false;
    private ArrayList<String> genre;

    public MovieChecked() {
    }

    public MovieChecked(String name, String thumbnailUrl, int year, double rating,
                 ArrayList<String> genre,boolean checked) {
        this.title = name;
        this.thumbnailUrl = thumbnailUrl;
        this.year = year;
        this.rating = rating;
        this.genre = genre;
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public boolean isChecked(){return checked;}

    public void setChecked(boolean checked){this.checked = checked;}

    public void toogleChecked(){checked =!checked;}
}
