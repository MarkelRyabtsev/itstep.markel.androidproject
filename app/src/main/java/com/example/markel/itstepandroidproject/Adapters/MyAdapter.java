package com.example.markel.itstepandroidproject.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.markel.itstepandroidproject.Entities.Tree;
import com.example.markel.itstepandroidproject.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Tree> arrayListTrees = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<Tree> arrayListTrees){
        this.context = context;
        this.arrayListTrees = arrayListTrees;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tree_recyclerview_tree, viewGroup);
        return new TreesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return arrayListTrees.size();
    }

    public class TreesHolder extends RecyclerView.ViewHolder{

        public TreesHolder(View itemView) {
            super(itemView);
        }
    }
}
