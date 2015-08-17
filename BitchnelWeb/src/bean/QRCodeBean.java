package bean;

import java.io.Serializable;

import dao.RestaurantService;

public class QRCodeBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	RestaurantService rs = new RestaurantService();
	
	private String email = Util.getUserName();
	private String name = rs.getNameInfo(email);
	private int id = rs.getIdInfo(email);
	
	private String renderMethod;  
    private String text;  
    private String label;  
    private int mode;  
    private int size;  
    private String fillColor; 
    
  
    public QRCodeBean() 
    {  
        renderMethod = "canvas";  
        text = Integer.toString(id);  
        label = name;  
        mode = 2;  
        fillColor = "7d767d";  
        size = 200;  
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

	public String getRenderMethod() {
		return renderMethod;
	}

	public void setRenderMethod(String renderMethod) {
		this.renderMethod = renderMethod;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
}  