package com.example.daftarfilm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListClassMatesAdapter extends
        RecyclerView.Adapter<ListClassMatesAdapter.ListViewHolder>{
    private ArrayList<ClassMates> listClassMates;
    private OnItemClickCallback onItemClickCallback;

    public ListClassMatesAdapter(ArrayList<ClassMates> list) {
        this.listClassMates = list;
    }

    public interface OnItemClickCallback {
        void onItemClicked(ClassMates data);
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_classmates, parent, false);
        return new ListViewHolder(view);
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position)
    {
        ClassMates myclass = listClassMates.get(position);
        Glide.with(holder.itemView.getContext()).load(myclass.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvJudul.setText(myclass.getJudul());
        holder.tvGenre.setText(myclass.getGenre());
        holder.tvTglrilis.setText(myclass.getTglRilis());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listClassMates.get(holder.getAdapterPosition()));
            }
        });

    }
    @Override
    public int getItemCount() {
        return listClassMates.size();
    }
    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvJudul, tvGenre, tvTglrilis;
        public ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvJudul = itemView.findViewById(R.id.tv_item_judul);
            tvGenre = itemView.findViewById(R.id.tv_item_genre);
            tvTglrilis = itemView.findViewById(R.id.tv_item_tglrilis);
        }
    }
}