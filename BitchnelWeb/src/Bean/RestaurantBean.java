package bean;

import dao.RestaurantService;

public class RestaurantBean
{
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
	
	RestaurantService rs = new RestaurantService();
	
	public void updateName()
	{
		
	}
	
	public void updateEmail()
	{
		
	}
	
	public void updatePassword()
	{
		
	}
	
	public void updateDescription()
	{
		
	}
	
	public void updateProvince()
	{
		
	}
	
	public void updateLocation()
	{
		
	}
	
	public void updatePhonei()
	{
		
	}
	
	public void updatePhoneii()
	{
		
	}
	
	public void updatePhoneiii()
	{
		
	}
	
	public void updateSchedule()
	{
		
	}
	
	public void updateImg()
	{
		
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
