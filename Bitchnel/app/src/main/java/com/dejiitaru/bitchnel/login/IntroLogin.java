package com.dejiitaru.bitchnel.login;


import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import com.dejiitaru.bitchnel.MainActivity;
import com.dejiitaru.bitchnel.R;
import com.facebook.FacebookSdk;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

import java.io.InputStream;

public class IntroLogin  extends Activity {

    // Google client to interact with Google API

    private Button login;
    private SignInButton google;
    private Button failbook;


    /**
     * A flag indicating that a PendingIntent is in progress and prevents us
     * from starting further intents.
     */
    private boolean mIntentInProgress;

    private boolean mSignInClicked;

    private ConnectionResult mConnectionResult;

    private SignInButton btnSignIn;
    private Button btnSignOut;
    private Intent intent;
    private ImageView imgProfilePic;
    private TextView txtName, txtEmail;
    private LinearLayout llProfileLayout;

    public IntroLogin() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login_google_failbook);

        login = (Button) findViewById(R.id.normal_login);

        google = (SignInButton) findViewById(R.id.google_intro_login);
        google.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(google)) {
                    Intent intent = new Intent(IntroLogin.this, GoogleLogin.class);
                    startActivity(intent);
                }

            }
        });
        failbook = (Button) findViewById(R.id.failbook_intro_login);



    }


}


