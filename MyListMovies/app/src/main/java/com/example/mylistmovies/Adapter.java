package com.example.mylistmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class Holder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView title, genre, tgl_release;

    public Holder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image_view);
        title = itemView.findViewById(R.id.txt_title);
        genre = itemView.findViewById(R.id.txt_genre);
        tgl_release = itemView.findViewById(R.id.txt_tglRelease);
    }
}

public class Adapter extends RecyclerView.Adapter<Holder> {
    Context context;
    ArrayList<Movies> listMovies;

    public Adapter(Context context, ArrayList<Movies> listMovies) {
        this.context = context;
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_movies, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Movies movies = listMovies.get(position);
        holder.image.setImageResource(movies.getImage());
        holder.title.setText(movies.getJudulFilm());
        holder.genre.setText(movies.getGenre());
        holder.tgl_release.setText(movies.getTgl_release());
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }
}
