package bean;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import dao.EventService;
import dao.RestaurantService;
import main.Event;

public class EventBean 
{
RestaurantService rs = new RestaurantService();
	
	private String email = Util.getUserName();
	private String rname = rs.getNameInfo(email);
	private int rid = rs.getIdInfo(email);
	
	private int id;
	private int restaurant_id;
	private String name;
	private String description;
	private String contact;
	
	EventService es = new EventService();
	
	public void addEvent()
	{
		es.addEvent(id, rid, name, description, contact);
	}
	
	public void deleteEvent()
	{
		
	}
	
	 public ArrayList<Event> showAllEvents()
		{
			ArrayList<Event> event = es.showAllEvents(rid);
			
			for (Event e : event)
			{
				e.getName();
			}
			return event;
		}
	
	 public void onRowEdit(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Event Edited", ((Event) event.getObject()).getName());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Event) event.getObject()).getName());
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
