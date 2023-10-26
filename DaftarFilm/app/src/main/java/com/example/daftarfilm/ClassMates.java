package com.example.daftarfilm;

import android.os.Parcel;
import android.os.Parcelable;

public class ClassMates implements Parcelable {
    private String judul;
    private String genre;
    private String tglRilis;
    private String photo;
    public ClassMates() {
    }
    protected ClassMates(Parcel in) {
        judul = in.readString();
        genre = in.readString();
        tglRilis = in.readString();
        photo = in.readString();
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
    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getPhoto() {
        return photo;
    }

    public String getTglRilis() {
        return tglRilis;
    }

    public void setTglRilis(String tglRilis) {
        this.tglRilis = tglRilis;
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
        dest.writeString(judul);
        dest.writeString(genre);
        dest.writeString(tglRilis);
        dest.writeString(photo);
    }
}