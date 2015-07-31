package Main;

public class Restaurant 
{
	private int id;
	private String name;
	private String email;
	private String password;
	private String description;
	private String province;
	private String location;
	private int phonei;
	private int phoneii;
	private int phoneiii;
	private String schedule;
	private byte[] img;
	
	public Restaurant()
	{
		
	}

	public Restaurant(int id, String name, String email, String password, String description, String province, String location, int phonei, int phoneii, int phoneiii, String schedule, byte[] img) 
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.description = description;
		this.province = province;
		this.location = location;
		this.phonei = phonei;
		this.phoneii = phoneii;
		this.phoneiii = phoneiii;
		this.schedule = schedule;
		this.img = img;
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
