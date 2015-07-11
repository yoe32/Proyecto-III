package com.dejiitaru.bitchnel;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Usuario on 7/11/2015.
 */
public class UserPostActivity extends Fragment {


public UserPostActivity(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_login_google_failbook, container, false);

        return rootView;
    }
      public void goToAttach(View v){
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }


}


