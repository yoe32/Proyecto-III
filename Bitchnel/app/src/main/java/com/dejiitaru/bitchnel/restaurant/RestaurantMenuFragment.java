package com.dejiitaru.bitchnel.restaurant;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.dejiitaru.bitchnel.R;
import com.dejiitaru.bitchnel.adapter.CustomListAdapter;
import com.dejiitaru.bitchnel.app.AppController;
import com.dejiitaru.bitchnel.model.Movie;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenuFragment extends Fragment {

	// Log tag
	private static final String TAG = RestaurantMenuFragment.class.getSimpleName();

	// Movies json url
	private static final String url = "http://api.androidhive.info/json/movies.json";
	private ProgressDialog pDialog;
	private List<Movie> movieList = new ArrayList<Movie>();
	private ListView listView;
	private CustomListAdapter adapter;


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
						Movie movie = new Movie();
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
		adapter = new CustomListAdapter(getActivity(),movieList);
		ListView listView = (ListView) getView().findViewById(R.id.listViewMenu);
		listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

		listView.setAdapter(adapter);

		fetch();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_restaurant_menu, container, false);


		return rootView;
	}

	public void deleteSelected(View view) {
		//Obtengo los elementos seleccionados de mi lista
		SparseBooleanArray seleccionados = listView.getCheckedItemPositions();

		if(seleccionados==null || seleccionados.size()==0){
			//Si no había elementos seleccionados...
			Toast.makeText(getActivity(), "No hay elementos seleccionados", Toast.LENGTH_SHORT).show();
		}else{
			//si los había, miro sus valores

			//Esto es para ir creando un mensaje largo que mostraré al final
			StringBuilder resultado=new StringBuilder();
			resultado.append("Se eliminarán los siguientes elementos:\n");

			//Recorro my "array" de elementos seleccionados
			final int size=seleccionados.size();
			for (int i=0; i<size; i++) {
				//Si valueAt(i) es true, es que estaba seleccionado
				if (seleccionados.valueAt(i)) {
					//en keyAt(i) obtengo su posición
					resultado.append("El elemento "+seleccionados.keyAt(i)+" estaba seleccionado\n");
				}
			}
			Toast.makeText(getActivity(),resultado.toString(),Toast.LENGTH_LONG).show();
		}
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
