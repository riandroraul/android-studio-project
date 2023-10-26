package com.example.intentpertemuan10;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String name, nim;
    private int age, nilaiUts, nilaiTugas, nilaiUas;


    protected Person(Parcel in) {
        name = in.readString();
        email = in.readString();
        age = in.readInt();
        nim = in.readString();
        city = in.readString();
        nilaiUts = in.readInt();
        nilaiTugas = in.readInt();
        nilaiUas = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public Person() {

    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public int getNilaiUts() {
        return nilaiUts;
    }

    public void setNilaiUts(int nilaiUts) {
        this.nilaiUts = nilaiUts;
    }

    public int getNilaiTugas() {
        return nilaiTugas;
    }

    public void setNilaiTugas(int nilaiTugas) {
        this.nilaiTugas = nilaiTugas;
    }

    public int getNilaiUas() {
        return nilaiUas;
    }

    public void setNilaiUas(int nilaiUas) {
        this.nilaiUas = nilaiUas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String email;
    private String city;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeInt(age);
        dest.writeString(nim);
        dest.writeString(city);
        dest.writeInt(nilaiTugas);
        dest.writeInt(nilaiUts);
        dest.writeInt(nilaiUas);
    }
}
