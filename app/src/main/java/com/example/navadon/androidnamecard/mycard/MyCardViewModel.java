package com.example.navadon.androidnamecard.mycard;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MyCardViewModel extends ViewModel {
    private DatabaseReference mFirebaseDatabase;
    public ObservableField<String> firstname = new ObservableField<>("");
    public ObservableField<String> lastname = new ObservableField<>("");
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> imageUrl = new ObservableField<>("");
    public ObservableField<String> address = new ObservableField<>("");

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

    public void getInformationWithFirebase(String userId){
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();
        mFirebaseDatabase.child("users").child(userId).addValueEventListener(valueFromGoogle);
    }

}
