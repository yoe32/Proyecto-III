package main;

public class Event {

	private String name;
	private String descripcion;
	private String contact;
	
	public Event()
	{
		
	}
	
	public Event(String name, String descripcion, String contact)
	{
		super();
		this.name = name;
		this.descripcion = descripcion;
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
