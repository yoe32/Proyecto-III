package com.dejiitaru.bitchnel.login;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
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
    Button share,details;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_listview_header_facebook);

        callbackManager = CallbackManager.Factory.create();
        login = (LoginButton)findViewById(R.id.failbook_intro_login);
        share = (Button)findViewById(R.id.share);
        details = (Button)findViewById(R.id.details);
        profile = (ProfilePictureView)findViewById(R.id.picture);
        shareDialog = new ShareDialog(this);

        share.setVisibility(View.INVISIBLE);
        details.setVisibility(View.INVISIBLE);

        login.setReadPermissions("public_profile email");

        details_dialog = new Dialog(this);
        details_dialog.setContentView(R.layout.activity_facebook_dialog_details);
        details_dialog.setTitle("Details");
        details_txt = (TextView)details_dialog.findViewById(R.id.details);

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details_dialog.show();
            }
        });

        if(AccessToken.getCurrentAccessToken() != null){
            RequestData();
            share.setVisibility(View.INVISIBLE);
            details.setVisibility(View.INVISIBLE);
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AccessToken.getCurrentAccessToken() != null) {
                    share.setVisibility(View.INVISIBLE);
                    details.setVisibility(View.INVISIBLE);
                    profile.setProfileId(null);

                }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareLinkContent content = new ShareLinkContent.Builder().build();
                shareDialog.show(content);

            }
        });

        login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                if (AccessToken.getCurrentAccessToken() != null) {
                    RequestData();
                    Intent intent = new Intent(FacebookLogin.this,MainActivity.class);
                    startActivity(intent);

                    //    details_txt.setVisibility(View.VISIBLE);
                }
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
                   //     details_txt.setText(Html.fromHtml(text));
                    //    profile.setProfileId(json.getString("id"));
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

