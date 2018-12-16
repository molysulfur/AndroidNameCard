package com.example.navadon.androidnamecard.profile;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.navadon.androidnamecard.R;
import com.example.navadon.androidnamecard.databinding.ActivityProfileBinding;
import com.example.navadon.androidnamecard.mycard.MyCardActivity;

public class ProfileActivity extends AppCompatActivity {
    private ProfileViewModel profileViewModel;
    ActivityProfileBinding profileBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInstances();
    }

    public void save(View view){
            String userId = profileViewModel.save();
            Intent intent = new Intent(ProfileActivity.this, MyCardActivity.class);
            intent.putExtra("userId",userId);
            startActivity(intent);
            finish();
    }

    private void initInstances() {
        profileViewModel = new ProfileViewModel();
        profileBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        profileBinding.setViewModel(profileViewModel);
        String userId = getIntent().getStringExtra("userId");

        profileViewModel.getInformationWithFirebase(userId);
        setTextWatcher();
        setImageUrl();
    }

    private void setTextWatcher() {
        profileBinding.etAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                profileViewModel.address.set(s.toString());
            }
        });
        profileBinding.etFirstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                profileViewModel.firstname.set(s.toString());
            }
        });
        profileBinding.etLastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                profileViewModel.lastname.set(s.toString());
            }
        });
        profileBinding.etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                profileViewModel.email.set(s.toString());
            }
        });
    }

    private void setImageUrl() {
        try{
            if (!profileViewModel.imageUrl.get().equals("")) {
                Glide.with(this)
                        .load(profileViewModel.imageUrl.get())
                        .into((ImageView) findViewById(R.id.img_profile));
            }
        }catch (NullPointerException e){
            Log.e("Set Image Profile", "You don't set profile in google");
        }

    }


}
