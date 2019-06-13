package com.akash.webservicegetretrofit;

import com.google.gson.annotations.SerializedName;

public class Movies {

    @SerializedName("image")
    private String image;

    @SerializedName("title")
    private String titile;

    @SerializedName("rating")
    private String rating;

    @SerializedName("releaseYear")
    private String releaseYear;

    public Movies(String image, String titile, String rating, String releaseYear) {
        this.image = image;
        this.titile = titile;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
}
