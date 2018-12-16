package com.example.navadon.androidnamecard.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.navadon.androidnamecard.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListCardViewHolder extends RecyclerView.ViewHolder {

    public TextView mName;
    public TextView mLastname;
    public TextView mEmail;
    public TextView mAddress;
    public CircleImageView circleImageView;

    public ListCardViewHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.tv_firstname);
        mLastname = itemView.findViewById(R.id.tv_lastname);
        mEmail = itemView.findViewById(R.id.tv_email);
        mAddress = itemView.findViewById(R.id.tv_address);
        circleImageView = itemView.findViewById(R.id.img_profile);
    }
}
