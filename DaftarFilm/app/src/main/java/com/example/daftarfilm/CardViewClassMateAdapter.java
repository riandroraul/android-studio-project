package com.example.daftarfilm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewClassMateAdapter extends
        RecyclerView.Adapter<CardViewClassMateAdapter.CardViewViewHolder>{
    private ArrayList<ClassMates> listClassMate;

    public CardViewClassMateAdapter(ArrayList<ClassMates> list) {
        this.listClassMate = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_classmate, viewGroup, false);
        return new CardViewViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        ClassMates myclass = listClassMate.get(position);
        Glide.with(holder.itemView.getContext())
                .load(myclass.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvJudul.setText(myclass.getJudul());
        holder.tvGenre.setText(myclass.getGenre());
        holder.tvTglRilis.setText(myclass.getTglRilis());
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite " +
                                listClassMate.get(holder.getAdapterPosition()).getJudul(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Share " +
                                listClassMate.get(holder.getAdapterPosition()).getJudul(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listClassMate.get(holder.getAdapterPosition()).getJudul(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return listClassMate.size();
    }
    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvJudul, tvGenre, tvTglRilis;
        Button btnFavorite, btnShare;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvJudul = itemView.findViewById(R.id.tv_item_judul);
            tvGenre = itemView.findViewById(R.id.tv_item_genre);
            tvTglRilis = itemView.findViewById(R.id.tv_item_tglrilis);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }

}
