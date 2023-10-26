package com.example.mylistmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView movies;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Movies> listmovies;

    protected void dataMovies(){
        listmovies = new ArrayList<>();
        listmovies.add(new Movies("KKN Di Desa Penari", "Horror", "30 April 2022", R.drawable.kkn_di_desa_penari__2022_));
        listmovies.add(new Movies("KKN Di Des", "Horror", "30 April 2022", R.drawable.the_avengers_2012));
    }

    protected void data(){
        movies = findViewById(R.id.list_item);
        adapter = new Adapter(this, listmovies);
        layoutManager = new LinearLayoutManager(this);
        movies.setLayoutManager(layoutManager);
        movies.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataMovies();
        data();
    }
}