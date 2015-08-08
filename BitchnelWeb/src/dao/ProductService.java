package dao;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Product;

public class ProductService extends Service 
{
	public void addProduct(int id, int restaurant_id, String name, String description, double price, InputStream picture)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_product (restaurant_product_id,restaurant_profile_id,restaurant_product,product_description,product_price,product_img)values(?,?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setInt(2, restaurant_id);
            ps.setString(3, name);
            ps.setString(4, description);
            ps.setDouble(5, price);
            ps.setBlob(6, picture);
            ps.executeUpdate();
            
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
	
	public void deleteProduct(int restaurant_id, int restaurant_product_id)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("DELETE FROM restaurant_product WHERE restaurant_profile_id='" + restaurant_id + "'  AND restaurant_product_id='" + restaurant_product_id + "' ");
            ps.setInt(1, restaurant_id);
            ps.setInt(2, restaurant_product_id);
            ps.execute();
            
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
	
	public ArrayList<Product> showAllProducts(int id)
	{
		ArrayList<Product> product = new ArrayList<Product>();
		
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM restaurant_product WHERE restaurant_profile_id='" + id + "'");

			while (rs.next()) 
			{
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setRestaurant_id(rs.getInt(2));
				p.setName(rs.getString(3));
				p.setDescription(rs.getString(4));
				p.setPrice(rs.getDouble(5));
				p.setPicture(rs.getBlob(6));
				product.add(p);
			}
			
			if (rs != null) 
			{
				rs.close();
			}

			if (st != null) 
			{
				st.close();
			}
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		desconectar();
		return product;
	}
}
