package Main;

public class Restaurant 
{
	private int restaurant_profile_id;
	private String restaurant_name;
	private String restaurant_email;
	private String restaurant_password;
	private String restaurant_description;
	private String restaurant_location;
	private byte[] restaurant_img;
	
	public int getRestaurant_profile_id() {
		return restaurant_profile_id;
	}
	public void setRestaurant_profile_id(int restaurant_id) {
		this.restaurant_profile_id = restaurant_id;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public String getRestaurant_email() {
		return restaurant_email;
	}
	public void setRestaurant_email(String restaurant_email) {
		this.restaurant_email = restaurant_email;
	}
	public String getRestaurant_password() {
		return restaurant_password;
	}
	public void setRestaurant_password(String restaurant_password) {
		this.restaurant_password = restaurant_password;
	}
	public String getRestaurant_description() {
		return restaurant_description;
	}
	public void setRestaurant_description(String restaurant_description) {
		this.restaurant_description = restaurant_description;
	}
	public String getRestaurant_location() {
		return restaurant_location;
	}
	public void setRestaurant_location(String restaurant_location) {
		this.restaurant_location = restaurant_location;
	}
	public byte[] getRestaurant_img() {
		return restaurant_img;
	}
	public void setRestaurant_img(byte[] restaurant_img) {
		this.restaurant_img = restaurant_img;
	}
}
