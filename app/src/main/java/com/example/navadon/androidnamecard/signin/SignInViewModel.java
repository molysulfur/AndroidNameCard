package com.example.navadon.androidnamecard.signin;

import android.arch.lifecycle.ViewModel;

public class SignInViewModel extends ViewModel {

    private String information;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public SignInViewModel(){
        this.information = "Click at logo to sign in with Google account";
    }
}
