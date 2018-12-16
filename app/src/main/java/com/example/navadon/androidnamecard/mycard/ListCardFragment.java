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
import com.example.navadon.androidnamecard.databinding.FragmentListcardBinding;

public class ListCardFragment extends Fragment {
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
        myCardViewModel.getListInformationWithFirebase(userId);
    }
}
