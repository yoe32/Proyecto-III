package com.dejiitaru.bitchnel.model;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by Usuario on 8/8/2015.
 */
public class SelectViewHolder{
    private TextView titles;
    private TextView rate;
    private TextView genres;
    private TextView releaseYear;
    private CheckBox checkBox;
   private NetworkImageView images;


        public SelectViewHolder(TextView titles, TextView rate, TextView genres, TextView releaseYear,
                            CheckBox checkBox,NetworkImageView images) {
            this.titles = titles;
            this.rate = rate;
            this.genres = genres;
            this.releaseYear = releaseYear;
            this.checkBox = checkBox;
            this.images = images;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public void setCheckBox(CheckBox checkBox) {
            this.checkBox = checkBox;
        }

        public TextView getText01() {
            return titles;
        }

        public void setText01(TextView textView) {
            this.titles = textView;
        }

    public TextView getText02() {
        return rate;
    }

    public void setText02(TextView textView) {
        this.rate = textView;
    }
    public TextView getText03() {
        return genres;
    }

    public void setText03(TextView textView) {
        this.genres = textView;
    }

    public TextView getText04() {
        return releaseYear;
    }

    public void setText04(TextView textView) {
        this.releaseYear = textView;
    }

        public NetworkImageView getImageView01(){return images;}

        public void setImageView01(NetworkImageView images){this.images = images;}


}
