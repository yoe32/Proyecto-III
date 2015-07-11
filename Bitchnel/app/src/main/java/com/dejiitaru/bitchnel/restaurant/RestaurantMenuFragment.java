package com.dejiitaru.bitchnel.restaurant;

import com.dejiitaru.bitchnel.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RestaurantMenuFragment extends Fragment
{
    public RestaurantMenuFragment()
    {

    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_restaurant_menu, container, false);
		return rootView;
	}
}
