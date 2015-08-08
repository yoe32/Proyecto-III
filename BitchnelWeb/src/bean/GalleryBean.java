package bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import dao.GalleryService;
import dao.RestaurantService;
import main.Gallery;

public class GalleryBean 
{
	RestaurantService rs = new RestaurantService();
	GalleryService gs = new GalleryService();

	private String email = Util.getUserName();
	private String name = rs.getNameInfo(email);
	private int id = rs.getIdInfo(email);
	private Gallery selectedPicture;
	
	public void handleFileUpload(FileUploadEvent event) throws IOException 
	{
		System.out.println(id);
		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		gs.addImg(0,id, event.getFile().getInputstream(), event.getFile().getFileName());
	}
	
	public ArrayList<Gallery> showAllGallery()
	{
		ArrayList<Gallery> gallery = gs.showAllGallery(id);
		
		for (Gallery g : gallery)
		{
			g.getName();
			g.getPicture();
		}
		return gallery;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gallery getSelectedPicture() {
		return selectedPicture;
	}

	public void setSelectedPicture(Gallery selectedPicture) {
		this.selectedPicture = selectedPicture;
	}
}
