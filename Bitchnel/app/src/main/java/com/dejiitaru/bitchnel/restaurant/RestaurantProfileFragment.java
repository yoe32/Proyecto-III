package com.dejiitaru.bitchnel.restaurant;

import com.dejiitaru.bitchnel.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RestaurantProfileFragment extends Fragment
{
	public RestaurantProfileFragment()
	{

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_restaurant_profile, container, false);
		return rootView;
	}
}
