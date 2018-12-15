package com.example.navadon.androidnamecard.profile;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.navadon.androidnamecard.R;
import com.example.navadon.androidnamecard.databinding.ActivityProfileBinding;
import com.example.navadon.androidnamecard.model.User;

public class ProfileActivity extends AppCompatActivity {
    private ProfileViewModel profileViewModel;
    ActivityProfileBinding profileBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInstances();
    }

    public void onSubmit(){
    }

    private void initInstances() {
        profileViewModel = new ProfileViewModel();
        profileBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        profileBinding.setViewModel(profileViewModel);
        String userId = getIntent().getStringExtra("userId");

        profileViewModel.getInformationWithFirebase(userId);
        setImageUrl();
    }

    private void setImageUrl() {
        try{
            Glide.with(this)
                    .load(profileViewModel.imageUrl.get())
                    .into((ImageView) findViewById(R.id.img_profile));
        }catch (NullPointerException e){
            Log.e("Set Image Profile", "You don't set profile in google");
        }

    }


}
