package com.example.navadon.androidnamecard.mycard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navadon.androidnamecard.R;
import com.example.navadon.androidnamecard.adapter.RecyclerViewAdapter;
import com.example.navadon.androidnamecard.databinding.FragmentListcardBinding;
import com.example.navadon.androidnamecard.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListCardFragment extends Fragment {
    private DatabaseReference mFirebaseDatabase;
    private MyCardViewModel myCardViewModel = new MyCardViewModel();
    private String userId;
    FragmentListcardBinding fragmentListcardBinding;



    public static ListCardFragment newInstance(String userId) {
        ListCardFragment fragment = new ListCardFragment();
        Bundle args = new Bundle();
        args.putString("userId",userId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userId = getArguments().getString("userId");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentListcardBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_listcard,container,false);
        fragmentListcardBinding.setView(this);
        fragmentListcardBinding.setViewModel(myCardViewModel);
        View rootView = fragmentListcardBinding.getRoot();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInstances();
    }

    private void initInstances() {
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();
        mFirebaseDatabase.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList users = new ArrayList();
                for (DataSnapshot dataSnap : dataSnapshot.getChildren()){
                    User user = new User(dataSnap.getValue(User.class).firstname,
                            dataSnap.getValue(User.class).lastname,
                            dataSnap.getValue(User.class).email,
                            dataSnap.getValue(User.class).imageUrl,
                            dataSnap.getValue(User.class).address);
                    users.add(user);
                }
                Log.e("userList",users.toString());
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),users);
                fragmentListcardBinding.recyclerListcard.setLayoutManager(new LinearLayoutManager(getContext()));
                fragmentListcardBinding.recyclerListcard.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
