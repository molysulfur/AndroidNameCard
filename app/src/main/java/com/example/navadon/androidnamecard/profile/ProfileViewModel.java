package com.example.navadon.androidnamecard.profile;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.navadon.androidnamecard.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ProfileViewModel extends ViewModel {

    private DatabaseReference mFirebaseDatabase;
    public ObservableField<User> users = new ObservableField<>();

    private ValueEventListener valueFromGoogle = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            Map map = (Map) dataSnapshot.getValue();
            User user = new User();
            user.firstname = (String) map.get("firstname");
            user.lastname = (String) map.get("lastname");
            user.email = (String) map.get("email");
            user.imageUrl = (String) map.get("imageUrl");
            users.set(user);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    public void save(){

        Log.e("Profile ViewModel", users.get().getFirstname());
    }

    public void getInformationWithFirebase(String userId){
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();
        mFirebaseDatabase.child("users").child(userId).addValueEventListener(valueFromGoogle);
    }

}
