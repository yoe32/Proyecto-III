package Bean;

import Bean.LoginBean;
import DAO.RegisterService;
import Main.Restaurant;

public class RegisterBean
{
	private int id;
	private String name;
	private String email;
	private String password;
	private String description = "empty";
	private String province;
	private String location = "empty";
	private int phonei;
	private int phoneii  = 0;
	private int phoneiii = 0;
	private String schedule = "empty";
	private byte[] img = null;

	RegisterService rs = new RegisterService();
	Restaurant res = new Restaurant();
	LoginBean lb = new LoginBean();

	public String register()
	{
		rs.registerRestaurant(new Restaurant(id, name, email, password, description, province, location, phonei, phoneii, phoneiii, schedule, img));
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
}
