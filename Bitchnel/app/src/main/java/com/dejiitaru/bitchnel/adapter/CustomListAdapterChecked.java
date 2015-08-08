package com.dejiitaru.bitchnel.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.dejiitaru.bitchnel.R;
import com.dejiitaru.bitchnel.app.AppController;
import com.dejiitaru.bitchnel.model.Movie;
import com.dejiitaru.bitchnel.model.MovieChecked;
import com.dejiitaru.bitchnel.model.SelectViewHolder;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Usuario on 8/8/2015.
 */
public class CustomListAdapterChecked extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<MovieChecked> movieItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapterChecked(Activity activity, List<MovieChecked> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MovieChecked opcion = (MovieChecked) this.getItem(position);
        CheckBox checkBox;
        TextView title;
        TextView rating;
        TextView genre;
        TextView year;
        NetworkImageView thumbNail;


        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null){
            convertView = inflater.inflate(R.layout.volley_list_row_select_items, null);
        checkBox = (CheckBox) convertView.findViewById(R.id.checkBox01);
            thumbNail = (NetworkImageView) convertView.findViewById(R.id.thumbnail);
            title = (TextView) convertView.findViewById(R.id.title);
            rating = (TextView) convertView.findViewById(R.id.rating);
            genre = (TextView) convertView.findViewById(R.id.genre);
            year = (TextView) convertView.findViewById(R.id.releaseYear);

        convertView.setTag(new SelectViewHolder(title,rating,genre,year,checkBox,thumbNail));

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Nullable
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                MovieChecked movie = (MovieChecked) cb.getTag();
                movie.setChecked(cb.isChecked());
            }
        });
    }
        else{
            SelectViewHolder viewHolder = (SelectViewHolder)convertView.getTag();
            checkBox = viewHolder.getCheckBox();

        }

        checkBox.setTag(opcion);

        checkBox.setChecked(opcion.isChecked());

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        thumbNail = (NetworkImageView) convertView.findViewById(R.id.thumbnail);
        title = (TextView) convertView.findViewById(R.id.title);
        rating = (TextView) convertView.findViewById(R.id.rating);
        genre = (TextView) convertView.findViewById(R.id.genre);
        year = (TextView) convertView.findViewById(R.id.releaseYear);

        // getting movie data for the row
        MovieChecked m = movieItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // title
        title.setText(m.getTitle());

        // rating
        rating.setText("Rating: " + String.valueOf(m.getRating()));

        // genre
        String genreStr = "";
        for (String str : m.getGenre()) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        genre.setText(genreStr);

        // release year
        year.setText(String.valueOf(m.getYear()));

        return convertView;

    }
}
