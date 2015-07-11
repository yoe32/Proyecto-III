package com.dejiitaru.bitchnel;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.dejiitaru.bitchnel.R;

import com.dejiitaru.bitchnel.R;

import com.dejiitaru.bitchnel.restaurant.RestaurantProfileActivity;

public class HomeFragment extends Fragment
{
    private Button btnRest;

    public HomeFragment()
    {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        btnRest = (Button)rootView.findViewById(R.id.btn_restaurant);

        btnRest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Create Intent Element
               final Intent intent = new Intent(getActivity(),RestaurantProfileActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
