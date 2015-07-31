package Main;

public class Menu 
{
	private String product;
	private String descripcion;
	private byte[] img;
	
	
	public Menu()
	{
		
	}
	
	public Menu(String product, String descripcion, byte[] img) 
	{
		super();
		this.product = product;
		this.descripcion = descripcion;
		this.img = img;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
}
