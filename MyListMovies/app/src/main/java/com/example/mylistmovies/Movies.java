package com.example.mylistmovies;

public class Movies {
    private String judulFilm, genre, tgl_release;
    private int image;

    public Movies(String judulFilm, String genre, String tgl_release, int image) {
        this.judulFilm = judulFilm;
        this.genre = genre;
        this.tgl_release = tgl_release;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getJudulFilm() {
        return judulFilm;
    }

    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTgl_release() {
        return tgl_release;
    }

    public void setTgl_release(String tgl_release) {
        this.tgl_release = tgl_release;
    }
}
