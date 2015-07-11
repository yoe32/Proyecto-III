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

    public HomeFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }
}
