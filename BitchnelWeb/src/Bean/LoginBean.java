package Bean;

import DAO.RestaurantService;

public class LoginBean 
{
	private String email;
	private String password;
	
	RestaurantService rs = new RestaurantService();
	
	public String login(String email, String password)
	{
		if(rs.login(email, password) == true)
		{
			return "restaurant";
		}
		else
		{
			System.out.println(email);
			System.out.println(password);
			return "index";
		}
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
}
