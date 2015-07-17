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
	private int phone_i;
	private int phone_ii;
	private int phone_iii;
	private byte[] img;
	
	RestaurantService rservice = new RestaurantService();
	
	public String register(int id, String name, String email, String password, String description, String location, int phone_i, int phone_ii, int phone_iii, byte[] img)
	{
		rservice.registerRestaurant(new Restaurant(id, name, email, password, description, location, phone_i, phone_ii, phone_iii, null));
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

	public int getPhone_i() {
		return phone_i;
	}

	public void setPhone_i(int phone_i) {
		this.phone_i = phone_i;
	}

	public int getPhone_ii() {
		return phone_ii;
	}

	public void setPhone_ii(int phone_ii) {
		this.phone_ii = phone_ii;
	}

	public int getPhone_iii() {
		return phone_iii;
	}

	public void setPhone_iii(int phone_iii) {
		this.phone_iii = phone_iii;
	}
	
	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
}
