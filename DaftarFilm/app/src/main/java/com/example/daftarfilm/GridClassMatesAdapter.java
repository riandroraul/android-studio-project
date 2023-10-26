package com.example.daftarfilm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridClassMatesAdapter extends
        RecyclerView.Adapter<GridClassMatesAdapter.GridViewHolder>{
    private ArrayList<ClassMates> listClassMate;
    private OnItemClickCallback onItemClickCallback;
    public GridClassMatesAdapter(ArrayList<ClassMates> list) {
        this.listClassMate = list;
    }
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_classmate,
                        parent, false);
        return new GridViewHolder(view);
    }

    public void setOnItemClickCallback(OnItemClickCallback
                                               onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listClassMate.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listClassMate.get(holder.getAdapterPosition()));
            }
        });
    }
    public interface OnItemClickCallback {
        void onItemClicked(ClassMates data);
    }
    @Override
    public int getItemCount() {
        return listClassMate.size();
    }
    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}

