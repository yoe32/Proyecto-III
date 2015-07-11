package com.dejiitaru.bitchnel.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Activity;

import com.dejiitaru.bitchnel.R;
import com.facebook.FacebookSdk;
import com.google.android.gms.common.SignInButton;

public class IntroLogin  extends Activity {

    private Button login;
    private SignInButton google;
    private Button failbook;

    public IntroLogin() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login_google_failbook);

        login = (Button)findViewById(R.id.normal_login);
        google = (SignInButton)findViewById(R.id.google_intro_login);
        failbook = (Button)findViewById(R.id.failbook_intro_login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //         Intent intent = new Intent(IntroLogin.this,RegularLogin.class);
                //          startActivity(intent);
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroLogin.this,GoogleLogin.class);
                startActivity(intent);
            }
        });
        failbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroLogin.this,FacebookLogin.class);
                startActivity(intent);
            }
        });



    }
    }


