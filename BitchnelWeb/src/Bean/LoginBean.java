package Bean;

import DAO.LoginService;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.servlet.http.HttpServletRequest;

public class LoginBean 
{
	private String email;
	private String password;
	private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
	
	LoginService ls = new LoginService();
	
	public LoginBean() 
    {
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
    }
	
	public String login(String email, String password)
	{
		if(ls.login(email, password) == true)
		{
			httpServletRequest.getSession().setAttribute("sessionUsuario", email);
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
            faceContext.addMessage(null, facesMessage);
			return "restaurant";
		}
		else
		{
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto", null);
	        faceContext.addMessage(null, facesMessage);
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
