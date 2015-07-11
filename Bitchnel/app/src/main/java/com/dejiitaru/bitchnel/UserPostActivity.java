package com.dejiitaru.bitchnel;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.facebook.login.widget.LoginButton;

public class UserPostActivity extends Fragment {

    private Button btnSignOut;
    LoginButton login;
public UserPostActivity(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_google_facebook_user_post, container, false);
        rootView.setOnClickListener(null);

        return rootView;

    }



}


