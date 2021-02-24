package com.example.retrofit;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    ArrayList<PostModel> arrayList;

    public RecyclerAdapter(Context context, ArrayList<PostModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        PostModel postModel = arrayList.get(position);

        holder.nametxt.setText(postModel.getName());

        holder.realnametxt.setText(postModel.getRealname());
        holder.teamtxt.setText(postModel.getTeam());
        holder.firstapptxt.setText(postModel.getFirstappearance());
        holder.createdbytxt.setText(postModel.getCreatedby());
        holder.publishertxt.setText(postModel.getPublisher());
        holder.biotxt.setText(postModel.getBio());

        Glide
                .with(context)
                .load(postModel.getImageurl())
                .into(holder.imageurl);

//        String img = String.valueOf(postModel.getImageurl());
//
//        holder.imageurl.setImageResource(Integer.parseInt(img));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nametxt, realnametxt, teamtxt, firstapptxt, createdbytxt, publishertxt, biotxt;
        ImageView imageurl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nametxt = itemView.findViewById(R.id.nametxt);
            realnametxt = itemView.findViewById(R.id.realnametxt);
            teamtxt = itemView.findViewById(R.id.teamtxt);
            firstapptxt = itemView.findViewById(R.id.firstapptxt);
            createdbytxt = itemView.findViewById(R.id.createdbytxt);
            publishertxt = itemView.findViewById(R.id.publishertxt);
            biotxt = itemView.findViewById(R.id.biotxt);
            imageurl = itemView.findViewById(R.id.img);
        }
    }
}