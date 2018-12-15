package com.example.navadon.androidnamecard.profile;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ProfileViewModel extends ViewModel {

    private DatabaseReference mFirebaseDatabase;
    private String userId;
    public ObservableField<String> firstname = new ObservableField<>("");
    public ObservableField<String> lastname = new ObservableField<>("");
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> imageUrl = new ObservableField<>("");
    public ObservableField<String> address = new ObservableField<>("test");

    private ValueEventListener valueFromGoogle = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            Map map = (Map) dataSnapshot.getValue();
            firstname.set((String) map.get("firstname"));
            lastname.set((String) map.get("lastname"));
            email.set((String) map.get("email"));
            imageUrl.set((String) map.get("imageUrl"));
            address.set((String) map.get("address"));
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    public void save(){
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();
//        User user = new User(firstname.get(),lastname.get(),email.get(),imageUrl.get(),address.get());
        Log.e("TEST_LOG","sadsdas");
        mFirebaseDatabase.child("users").child(userId).setValue(address.get());
    }

    public void getInformationWithFirebase(String userId){
        this.userId = userId;
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();
        mFirebaseDatabase.child("users").child(userId).addValueEventListener(valueFromGoogle);
    }

}
