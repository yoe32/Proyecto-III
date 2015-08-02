package com.dejiitaru.bitchnel.restaurant;

import android.support.v4.app.Fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dejiitaru.bitchnel.R;

public class RestaurantEventFragment extends Fragment
{
    public RestaurantEventFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.fragment_restaurant_event, container, false);


        return rootView;
    }
}
