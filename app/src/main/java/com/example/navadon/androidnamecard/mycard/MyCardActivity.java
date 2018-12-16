package com.example.navadon.androidnamecard.mycard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.navadon.androidnamecard.R;
import com.example.navadon.androidnamecard.databinding.ActivityMycardBinding;

public class MyCardActivity extends AppCompatActivity {

    private MyCardViewModel mycardViewModel;
    ActivityMycardBinding mycardBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInstances();
    }

    private void initInstances() {
        mycardViewModel = new MyCardViewModel();
        mycardBinding = DataBindingUtil.setContentView(this,R.layout.activity_mycard);
        mycardBinding.setViewModel(mycardViewModel);
        String userId = getIntent().getStringExtra("userId");
        mycardViewModel.getInformationWithFirebase(userId);
    }
}
