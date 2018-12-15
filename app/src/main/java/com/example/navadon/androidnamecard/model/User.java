package com.example.navadon.androidnamecard.model;

import android.databinding.ObservableField;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class User {

    public String firstname;
    public String lastname;
    public String email;
    public String imageUrl;
    public String address;

    public User() {
        firstname = "";
        lastname = "";
        email = "";
        imageUrl = null;
        address ="";
    }

    public User(String firstname, String lastname, String email, String imageUrl , String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.imageUrl = imageUrl;
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("email", email);
        result.put("firstname", firstname);
        result.put("lastname", lastname);
        result.put("address", address);
        result.put("imageUrl", imageUrl);

        return result;
    }
}
