package bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import dao.ProductService;
import dao.RestaurantService;
import main.Product;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

public class ProductBean 
{
	RestaurantService rs = new RestaurantService();
	ProductService ps = new ProductService();
	
	private String email = Util.getUserName();
	private String rname = rs.getNameInfo(email);
	private int rid = rs.getIdInfo(email);
	
	private int id;
	private int restaurant_id;
	private String name;
	private String description;
	private double price;
	private InputStream picture;
	
	private UploadedFile file;
	 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void addProduct() throws IOException 
    {
        if(file != null)
        {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            ps.addProduct(id, rid, name, description, price, file.getInputstream());     
        }
    }
    
    public ArrayList<Product> showAllProducts()
	{
		ArrayList<Product> product = ps.showAllProducts(rid);
		
		for (Product p : product)
		{
			p.getName();
			p.getPicture();
		}
		return product;
	}
	
	public void deleteProduct()
	{
		
	}
	
	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Product Edited", ((Product) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Product) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public InputStream getPicture() {
		return picture;
	}
	public void setPicture(InputStream picture) {
		this.picture = picture;
	}
}
