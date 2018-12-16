package com.example.navadon.androidnamecard.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.navadon.androidnamecard.R;

public class ListCardViewHolder extends RecyclerView.ViewHolder {

    public TextView mName;
    public TextView mLastname;
    public TextView mEmail;
    public TextView mAddress;

    public ListCardViewHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.et_firstname);
        mLastname = itemView.findViewById(R.id.et_lastname);
        mEmail = itemView.findViewById(R.id.et_email);
        mAddress = itemView.findViewById(R.id.et_address);
    }
}
