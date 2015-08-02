package com.dejiitaru.bitchnel.restaurant;

import com.dejiitaru.bitchnel.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;


public class RestaurantProfileFragment extends Fragment
{


	GoogleMap googleMap;
	private static View view;

	public RestaurantProfileFragment()
	{

	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		if (view != null) {
			ViewGroup parent = (ViewGroup) view.getParent();
			if (parent != null)
				parent.removeView(view);
		}
		try {
			view = inflater.inflate(R.layout.fragment_restaurant_profile, container, false);
		} catch (InflateException e) {
			//GOOGLE MAPS
			createMapView();
			addMarker();
		}

		return view;





	}
	private void createMapView(){
		/**
		 * Catch the null pointer exception that
		 * may be thrown when initialising the map
		 */
		try {
			if(null == googleMap) {
				googleMap = ((SupportMapFragment) getFragmentManager().findFragmentById(
						R.id.mapView)).getMap();

				/**
				 * If the map is still null after attempted initialisation,
				 * show an error to the user
				 */
				if(null == googleMap) {
					Toast.makeText(getActivity(),
							"Error creating map", Toast.LENGTH_SHORT).show();
				}
			}
		} catch (NullPointerException exception) {
			Log.e("mapApp", exception.toString());
		}

	}
	//IF MAP IS TOUCH


	/**
	 * Adds a marker to the map
	 */
	private void addMarker(){

		/** Make sure that the map has been initialised **/
		if(null != googleMap){
			googleMap.addMarker(new MarkerOptions()
							.position(new LatLng(0, 0))
							.title("Marker")
							.draggable(true)
			);
		}
	}
}

