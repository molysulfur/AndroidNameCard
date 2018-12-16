package com.example.navadon.androidnamecard.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navadon.androidnamecard.R;
import com.example.navadon.androidnamecard.model.ListCardViewHolder;
import com.example.navadon.androidnamecard.model.User;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ListCardViewHolder> {

    private List<User> mUser;
    public Context mContext;

    public RecyclerViewAdapter(Context context, List<User> dataset) {
        mUser = dataset;
        mContext = context;
    }

    @NonNull
    @Override
    public ListCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.listcard, viewGroup, false);

        ListCardViewHolder viewHolder = new ListCardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListCardViewHolder listCardViewHolder, int i) {
        User player = mUser.get(i);
        listCardViewHolder.mName.setText(player.getFirstname());
        listCardViewHolder.mLastname.setText(player.getLastname());
        listCardViewHolder.mLastname.setText(player.getEmail());
        listCardViewHolder.mLastname.setText(player.getAddress());
    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }
}



