package Bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import DAO.LoginService;

public class LoginBean
{
	private String email;
	private String password;

	LoginService ls = new LoginService();

	public String login(String email, String password)
	{
		if(ls.login(email, password) == true)
		{
			// get Http Session and store username
			HttpSession session = Util.getSession();
			session.setAttribute("username", email);
			System.out.println(Util.getUserName());
			System.out.println(Util.getUserId());
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
