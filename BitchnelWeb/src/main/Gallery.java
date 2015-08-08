package main;

import java.sql.Blob;

public class Gallery 
{
	private int id;
	private int restaurant_id;
	private String name;
	private Blob picture;
	
	public Gallery() 
	{
		super();
	}

	
	public Gallery(int id, int restaurant_id, String name, Blob picture) 
	{
		super();
		this.id = id;
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.picture = picture;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRestaurant_id() {
		return restaurant_id;
	}


	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Blob getPicture() {
		return picture;
	}


	public void setPicture(Blob picture) {
		this.picture = picture;
	}
}
