package bean;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FileUploadEvent;
import dao.*;
import dao.LoginService;
import dao.RestaurantService;

public class GlobalBean
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

	LoginService ls = new LoginService();
	GalleryService gs = new GalleryService();
	RestaurantService rs = new RestaurantService();
	
	public void getRestaurantInfo(String email)
	{
		id = rs.getIdInfo(email);
		name = rs.getNameInfo(email);
		description = rs.getDescriptionInfo(email);
		province = rs.getProvinceInfo(email);
		location = rs.getLocationInfo(email);
		phonei = rs.getPhone1Info(email);
		phoneii = rs.getPhone2Info(email);
		phoneiii = rs.getPhone3Info(email);
		schedule = rs.getScheduleInfo(email);
		img = rs.getImgInfo(email);
	}

	//=============================================Login Methods=============================================//
	//*******************************************************************************************************//
	public String login(String email, String password)
	{
		if(ls.login(email, password) == true)
		{
			// get Http Session and store username
			HttpSession session = Util.getSession();
			session.setAttribute("username", email);
			getRestaurantInfo(email);
			return "home";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login!", "Please Try Again!"));
			// invalidate session, and redirect to other pages
			//message = "Invalid Login. Please Try Again!";
			return "login";
		}
	}

	public String logout()
	{
		HttpSession session = Util.getSession();
		session.invalidate();
		return "login";
	}
	//*******************************************************************************************************//
	//=======================================================================================================//
	
	
	
	public void handleFileUpload(FileUploadEvent event) throws IOException 
	{
		System.out.println(id);
		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		gs.addImg(0,id, event.getFile().getInputstream(), event.getFile().getFileName());
		
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}