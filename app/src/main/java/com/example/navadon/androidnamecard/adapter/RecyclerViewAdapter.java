package com.example.navadon.androidnamecard.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
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
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listcard, viewGroup, false);

        ListCardViewHolder viewHolder = new ListCardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListCardViewHolder listCardViewHolder, int i) {
        User user = mUser.get(i);
        listCardViewHolder.mName.setText(user.firstname);
        listCardViewHolder.mLastname.setText(user.lastname);
        listCardViewHolder.mEmail.setText(user.email);
        listCardViewHolder.mAddress.setText(user.address);
        try {
            if (!user.imageUrl.equals(""))
                Glide.with(mContext).load(user.imageUrl).into(listCardViewHolder.circleImageView);
        }catch (NullPointerException e){

        }

    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }
}



