package com.desafios.desafio5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.desafios.desafio5.model.Animales;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Animales> animalesList = new ArrayList<>();//data set
    private Context mContext;
    private OnItemClickListener listener;

    @NonNull
    @Override
    public AnimalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        //view = mLayoutInflater.inflate(R.layout.item_list_animal,parent,false);
        view = mLayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_animal,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.ViewHolder holder, int position) {
        Animales animales = animalesList.get(position);
        holder.textView.setText(animales.getName());

        Glide.with(holder.imageView.getContext()) //3
                .load(animales.getUrl())
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        return animalesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView imageView;
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagen);
            textView = itemView.findViewById(R.id.text);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.OnClick(this, getNameByPosition(getAdapterPosition()),getURLByPosition(getAdapterPosition()));
        }
    }

    private String getNameByPosition(int position){
        if (position != RecyclerView.NO_POSITION){
            return  animalesList.get(position).getName();
        }else{
            return "no Hay";
        }
    }

    private String getURLByPosition(int position){
        if (position != RecyclerView.NO_POSITION){
            return  animalesList.get(position).getUrl();
        }else{
            return "no Hay";
        }
    }

    public AnimalAdapter( List<Animales> animalesList, Context mContext, OnItemClickListener listener) {
       // this.mLayoutInflater = mLayoutInflater;
        this.animalesList = animalesList;
        this.mContext = mContext;
        this.listener = listener;
    }

    public interface OnItemClickListener{
        public void OnClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String URL);
    }
}


