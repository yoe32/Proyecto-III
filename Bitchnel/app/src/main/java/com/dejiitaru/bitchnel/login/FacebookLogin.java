package com.dejiitaru.bitchnel.login;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dejiitaru.bitchnel.MainActivity;
import com.dejiitaru.bitchnel.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import org.json.JSONException;
import org.json.JSONObject;


public class FacebookLogin extends Activity
{



    CallbackManager callbackManager;
    ShareDialog shareDialog;
    LoginButton login;
    ProfilePictureView profile;
    Dialog details_dialog;
    TextView details_txt;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        callbackManager = CallbackManager.Factory.create();
        login = (LoginButton)findViewById(R.id.failbook_intro_login);
        profile = (ProfilePictureView)findViewById(R.id.picture);
        shareDialog = new ShareDialog(this);

        login.setReadPermissions("public_profile email");

        details_dialog = new Dialog(this);
        details_dialog.setContentView(R.layout.activity_facebook_dialog_details);
        details_dialog.setTitle("Details");
        details_txt = (TextView)details_dialog.findViewById(R.id.details);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AccessToken.getCurrentAccessToken() != null) {

                    profile.setProfileId(null);
                }
            }
        });

        login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                if (AccessToken.getCurrentAccessToken() != null) {
                    login.setVisibility(View.GONE);
                    profile.setVisibility(View.VISIBLE);
                    details_txt.setVisibility(View.VISIBLE);
                    RequestData();

                }
//                Intent intent = new Intent(FacebookLogin.this,MainActivity.class);
//                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException exception) {
            }
        });

    }

    public void RequestData() {
        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {

                JSONObject json = response.getJSONObject();
                try {
                    if (json != null) {
                        String text = "<b>Name :</b> " + json.getString("name") + "<br><br><b>Email :</b> "+json.getString("email")+"<br><br><b>Profile link :</b> "+json.getString("link");
                        details_txt.setText(Html.fromHtml(text));
                        profile.setProfileId(json.getString("id"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,email,picture");
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

