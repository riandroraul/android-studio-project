package com.example.mylistmovies2;

import android.os.Parcel;
import android.os.Parcelable;

public class ClassMates implements Parcelable {
    private String title;
    private String genre;
    private String date_rilis;
    private String photo;
    public ClassMates() {
    }
    protected ClassMates(Parcel in) {
        title = in.readString();
        genre = in.readString();
        photo = in.readString();
        date_rilis = in.readString();
    }
    public static final Parcelable.Creator<ClassMates> CREATOR = new
            Parcelable.Creator<ClassMates>() {
                @Override
                public ClassMates createFromParcel(Parcel in) {
                    return new ClassMates(in);
                }
                @Override
                public ClassMates[] newArray(int size) {
                    return new ClassMates[size];
                }
            };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate_rilis() {
        return date_rilis;
    }

    public void setDate_rilis(String date_rilis) {
        this.date_rilis = date_rilis;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(genre);
        dest.writeString(date_rilis);
        dest.writeString(photo);
    }
}
