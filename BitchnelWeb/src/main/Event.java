package main;

public class Event 
{
	private int id;
	private int restaurant_id;
	private String name;
	private String description;
	private String contact;
	
	public Event() 
	{
		super();
	}

	public Event(int id, int restaurant_id, String name, String description, String contact) {
		super();
		this.id = id;
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.description = description;
		this.contact = contact;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
