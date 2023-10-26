package com.example.mylistmovies2;

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

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListClassMatesAdapter(ArrayList<ClassMates> list) {
        this.listClassMates = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_classmates,
                        parent, false);
        return new ListViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position)
    {
        ClassMates myclass = listClassMates.get(position);
        Glide.with(holder.itemView.getContext()).load(myclass.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvTitle.setText(myclass.getTitle());
        holder.tvGenre.setText(myclass.getGenre());
        holder.tvDaterilis.setText(myclass.getDate_rilis());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onItemClickCallback.onItemClicked(listClassMates.get(holder.getAdapterPosition
                        ()));
            }
        });
    }
    @Override
    public int getItemCount() {
        return listClassMates.size();

    }
    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvGenre, tvDaterilis;
        public ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvGenre = itemView.findViewById(R.id.tv_item_genre);
            tvDaterilis = itemView.findViewById(R.id.tv_item_tgl_release);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(ClassMates data);
    }
}
