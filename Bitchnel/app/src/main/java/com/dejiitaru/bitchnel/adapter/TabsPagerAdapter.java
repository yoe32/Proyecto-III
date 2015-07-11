package com.dejiitaru.bitchnel.adapter;

<<<<<<< HEAD
import com.dejiitaru.bitchnel.restaurant.RestaurantEventFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantGalleryFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantMenuFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantProfileFragment;
=======
import com.dejiitaru.bitchnel.restaurant.FourFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantEventFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantGalleryFragment;
import com.dejiitaru.bitchnel.restaurant.RestaurantMenuFragment;

<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
<<<<<<< HEAD
			return new RestaurantProfileFragment();
=======
			return new RestaurantEventFragment();
>>>>>>> origin/master
=======
			return new RestaurantEventFragment();
>>>>>>> origin/master
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
