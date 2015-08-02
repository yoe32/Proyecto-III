package com.dejiitaru.bitchnel.adapter;


import com.dejiitaru.bitchnel.restaurant.RestaurantEventFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantGalleryFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantMenuFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantProfileFragment;

import com.dejiitaru.bitchnel.restaurant.RestaurantProfileFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantEventFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantGalleryFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantMenuFragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter
{
	public TabsPagerAdapter(FragmentManager fm)
    {
		super(fm);
	}

	@Override
	public Fragment getItem(int index)
    {
		switch (index)
		{
		case 0:
			// Top Rated fragment activity
		return  new RestaurantProfileFragment();
		case 1:
			// Games fragment activity
			return new RestaurantGalleryFragment();
		case 2:
			// Movies fragment activity
			return new RestaurantMenuFragment();
        case 3:
            return new RestaurantEventFragment();
		}
		return null;
	}

	@Override
	public int getCount()
    {
		// get item count - equal to number of tabs
		return 4;
	}
}
