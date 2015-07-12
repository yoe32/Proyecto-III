package Main;

public class Event {

	private String event_name;
	private String event_descripcion;
	private String event_contact;
	
	public Event(){}
	
	public Event(String name, String descripcion, String contact) {
		super();
		this.event_name = name;
		this.event_descripcion = descripcion;
		this.event_contact = contact;
	}

	public String getEvent_Name() {
		return event_name;
	}

	public void setEvent_Name(String name) {
		this.event_name = name;
	}

	public String getEvent_Descripcion() {
		return event_descripcion;
	}

	public void setEvent_Descripcion(String descripcion) {
		this.event_descripcion = descripcion;
	}

	public String getEvent_Contact() {
		return event_contact;
	}

	public void setEvent_Contact(String contact) {
		this.event_contact = contact;
	}
	
	
	
}
