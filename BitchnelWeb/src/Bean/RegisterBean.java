package Bean;

import DAO.RestaurantService;
import Main.Restaurant;

public class RegisterBean 
{
	private int id;
	private String name;
	private String email;
	private String password;
	private String description;
	private String location;
	private int phonei;
	private int phoneii;
	private int phoneiii;
	private byte[] img;
	
	RestaurantService rs = new RestaurantService();
	Restaurant res = new Restaurant();
	
	public String register()
	{
		rs.registerRestaurant(new Restaurant(1, this.name, this.email, this.password, this.description, this.location, this.phonei, this.phoneii, this.phoneiii, null));
		return "index";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPhonei() {
		return phonei;
	}

	public void setPhonei(int phonei) {
		this.phonei = phonei;
	}

	public int getPhoneii() {
		return phoneii;
	}

	public void setPhoneii(int phoneii) {
		this.phoneii = phoneii;
	}

	public int getPhoneiii() {
		return phoneiii;
	}

	public void setPhoneiii(int phoneiii) {
		this.phoneiii = phoneiii;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
}
