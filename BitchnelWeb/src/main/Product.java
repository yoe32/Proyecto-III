package main;

import java.sql.Blob;

public class Product 
{
	private int id;
	private int restaurant_id;
	private String name;
	private String description;
	private double price;
	private Blob picture;
	
	public Product() 
	{
		super();
	}

	public Product(int id, int restaurant_id, String name, String descripcion, double price, Blob picture) {
		super();
		this.id = id;
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.description = descripcion;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}
}
