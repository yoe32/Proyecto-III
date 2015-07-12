package Main;

public class Menu {

	private String menu_product;
	private String menu_descripcion;
	private byte[] menu_img;
	
	
	public Menu(){
		
	}
	
	
	public Menu(String product, String descripcion, byte[] img) {
		super();
		this.menu_product = product;
		this.menu_descripcion = descripcion;
		this.menu_img = img;
	}
	
	public String getMenu_Product() {
		return menu_product;
	}

	public void setMenu_Product(String product) {
		this.menu_product = product;
	}
	public String getMenu_Descripcion() {
		return menu_descripcion;
	}
	public void setMenu_Descripcion(String descripcion) {
		this.menu_descripcion = descripcion;
	}
	public byte[] getMenu_Img() {
		return menu_img;
	}
	public void setMenu_Img(byte[] img) {
		this.menu_img = img;
	}
	
	
}
