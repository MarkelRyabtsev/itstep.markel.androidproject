package com.example.markel.itstepandroidproject.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.markel.itstepandroidproject.Contracts.IListView;
import com.example.markel.itstepandroidproject.Entities.Tree;
import com.example.markel.itstepandroidproject.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements IListView {

    RecyclerView mRecyclerViewUsers;
    LinearLayoutManager mLinearLayoutManagerVerticalUsers;
    ArrayList<Tree> mArrayListTrees = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    public void initViews() {
        mRecyclerViewUsers = (RecyclerView)findViewById(R.id.recyclerview_activity_list_trees);
    }

    @Override
    public void initListeners() {

    }

    public void initAdapter() {
        mLinearLayoutManagerVerticalUsers = new LinearLayoutManager(this);
        mRecyclerViewUsers.setLayoutManager(mLinearLayoutManagerVerticalUsers);
    }

    public void initializeArray() {
        for(int i = 0; i < 20; i++){

            mArrayListTrees.add(new Tree(
                    "Tree" + i,
                    "WoodColor",
                    (i*10)/2));
        }
    }
}
