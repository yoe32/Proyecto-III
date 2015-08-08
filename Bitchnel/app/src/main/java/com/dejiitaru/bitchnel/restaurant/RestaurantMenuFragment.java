package com.dejiitaru.bitchnel.restaurant;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.dejiitaru.bitchnel.R;
import com.dejiitaru.bitchnel.adapter.CustomListAdapter;
import com.dejiitaru.bitchnel.adapter.CustomListAdapterChecked;
import com.dejiitaru.bitchnel.app.AppController;
import com.dejiitaru.bitchnel.model.Movie;
import com.dejiitaru.bitchnel.model.MovieChecked;
import com.dejiitaru.bitchnel.model.SelectViewHolder;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenuFragment extends Fragment implements AdapterView.OnItemSelectedListener {


	// Log tag
	private static final String TAG = RestaurantMenuFragment.class.getSimpleName();

	// Movies json url
	private static final String url = "http://api.androidhive.info/json/movies.json";
	private ProgressDialog pDialog;
	private List<MovieChecked> movieList = new ArrayList<MovieChecked>();
	private ListView listView;

	private CustomListAdapterChecked adapter;


	private void fetch() {
		final JsonArrayRequest movieReq = new JsonArrayRequest(
				url,
				new Response.Listener<JSONArray>(){
			@Override
			public void onResponse(JSONArray response)  {
				hidePDialog();

				// Parsing json
				for (int i = 0; i < response.length(); i++) {
					try {

						JSONObject obj = response.getJSONObject(i);
						MovieChecked movie = new MovieChecked();
						movie.setTitle(obj.getString("title"));
						movie.setThumbnailUrl(obj.getString("image"));
						movie.setRating(((Number) obj.get("rating"))
								.doubleValue());
						movie.setYear(obj.getInt("releaseYear"));

						// Genre is json array
						JSONArray genreArry = obj.getJSONArray("genre");
						ArrayList<String> genre = new ArrayList<String>();
						for (int j = 0; j < genreArry.length(); j++) {
							genre.add((String) genreArry.get(j));
						}
						movie.setGenre(genre);

						// adding movie to movies array
						movieList.add(movie);

					} catch (JSONException e) {
						e.printStackTrace();
					}

				}

				// notifying list adapter about data changes
				// so that it renders the list view with updated data
				adapter.notifyDataSetChanged();
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				VolleyLog.d(TAG, "Error: " + error.getMessage());
				hidePDialog();

			}

		});
		// Adding request to request queue
		AppController.getInstance().addToRequestQueue(movieReq);

	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		final ListView listView = (ListView) getView().findViewById(R.id.listViewMenu);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
											@Nullable
											@Override
											public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
											MovieChecked item = movieList.get(position);
											item.toogleChecked();
											SelectViewHolder viewHolder = (SelectViewHolder)view.getTag();
												viewHolder.getCheckBox().setChecked(item.isChecked());
											}
										});
		adapter = new CustomListAdapterChecked(getActivity(),movieList);
				listView.setAdapter(adapter);

		fetch();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_restaurant_menu, container, false);
		// Spinner element
		Spinner spinner = (Spinner)rootView.findViewById(R.id.spinner);

		// Spinner click listener
		spinner.setOnItemSelectedListener(this);



		return rootView;
	}



	@Override
	public void onDestroy() {
		super.onDestroy();
		hidePDialog();
	}

	private void hidePDialog() {
		if (pDialog != null) {
			pDialog.dismiss();
			pDialog = null;
		}
	}


}
