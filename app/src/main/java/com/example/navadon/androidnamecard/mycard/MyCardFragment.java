package com.example.navadon.androidnamecard.mycard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navadon.androidnamecard.R;
import com.example.navadon.androidnamecard.databinding.FragmentMycardBinding;

public class MyCardFragment extends Fragment {

    private MyCardViewModel myCardViewModel = new MyCardViewModel();
    private String userId;
    public FragmentMycardBinding fragmentMycardBinding;

    public static MyCardFragment newInstance(String userId) {
        MyCardFragment fragment = new MyCardFragment();
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
        fragmentMycardBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_mycard,container,false);
        fragmentMycardBinding.setView(this);
        fragmentMycardBinding.setViewModel(myCardViewModel);
        View rootView = fragmentMycardBinding.getRoot();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInstances();
    }

    private void initInstances() {
        myCardViewModel.getInformationWithFirebase(userId);
    }
}
