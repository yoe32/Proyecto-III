package com.dejiitaru.bitchnel;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Usuario on 7/5/2015.
 */
public class GoogleActivity  extends Fragment{

    public GoogleActivity()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View rootView = inflater.inflate(R.layout.activity_main,container,false);
       return rootView;
    }
}
