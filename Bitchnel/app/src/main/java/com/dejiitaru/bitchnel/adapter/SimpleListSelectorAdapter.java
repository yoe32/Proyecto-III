package com.dejiitaru.bitchnel.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 8/1/2015.
 */
public class SimpleListSelectorAdapter extends ArrayAdapter<String> {

    /** Selected items in the list */
    private ArrayList<Integer> mSelection = new ArrayList<Integer>();

    /**
     25	     * Class construactor
     26	     * @param context Execution context
     27	     * @param resource list item layout
     28	     * @param textViewResourceId TextView identifier
     29	     * @param objects Array of list elements
     30	     */

    public SimpleListSelectorAdapter(Context context, int resource,
                                        int textViewResourceId, List<String> objects) {
        	        super(context, resource, textViewResourceId, objects);
        	    }

    /**
     37	     * Adds an element in selection and updates the view
     38	     * @param position Item position
     39	     */

    public void setNewSelection(int position) {
        	        mSelection.add(position);
        	        notifyDataSetChanged();
        	    }
    /**
     46	     * Get current selected items
     47	     * @return list of items
     48	     */

    public ArrayList<Integer> getCurrentCheckedPosition() {
        	        return mSelection;
            }

            	    /**
     54	     * Remove an element from selected items
     55	     * @param position Item position
     56	     */
            	    public void removeSelection(int position) {
        	        mSelection.remove(Integer.valueOf(position));
        	        notifyDataSetChanged();
        	    }

            	    /**
     63	     * Clear current selection
     64	     */
            	    public void clearSelection() {
        	        mSelection = new ArrayList<Integer>();
        	        notifyDataSetChanged();
        	    }

            	    /**
     71	     * Get number of selected items
     72	     * @return Selection count
     73	     */
            	    public int getSelectionCount() {
        	        return mSelection.size();
        	    }

            	    @Override
    	    public View getView(int position, View convertView, ViewGroup parent) {
        	        View v = super.getView(position, convertView, parent);

        	        v.setBackgroundColor(getContext().getResources().getColor(
                	                android.R.color.transparent)); // Default color

        	        if (mSelection.contains(position)) {
            	            v.setBackgroundColor(getContext().getResources().getColor(
                    	                    android.R.color.tab_indicator_text)); // color when selected
            	        }

        	        return v;
        	    }
}
