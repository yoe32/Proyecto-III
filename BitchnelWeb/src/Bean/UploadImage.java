package bean;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import dao.GalleryService;

public class UploadImage
{	
	private int id;
	
	@ManagedProperty(value="#{loginBean}")
    private GlobalBean loginBean;
 
    public GlobalBean getRequiredBean()
    {
        return loginBean;
    }
 
    public void setLoginBean(GlobalBean loginBean)
    {
        this.loginBean = loginBean;
    }
    
    


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = loginBean.getId();
	}




	GalleryService gs = new GalleryService();
	
	public void handleFileUpload(FileUploadEvent event) throws IOException 
	{
		System.out.println(id);
		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		gs.addImg(0,id, event.getFile().getInputstream(), event.getFile().getFileName());
		
	}
}
