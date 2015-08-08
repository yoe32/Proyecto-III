package dao;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import main.Gallery;

public class GalleryService extends Service
{
	
	public void addImg(int restaurant_id, int gallery_id, InputStream img, String name)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_gallery (restaurant_gallery_id,restaurant_profile_id,restaurant_picture,restaurant_picture_name)values(?,?,?,?)");
            ps.setInt(1, restaurant_id);
            ps.setInt(2, gallery_id);
            ps.setBlob(3, img);
            ps.setString(4, name);
            ps.executeUpdate();
            
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
	
	public void deleteImg(int restaurant_id, int gallery_id)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("DELETE FROM restaurant_gallery WHERE restaurant_profile_id='" + restaurant_id + "'  AND restaurant_profile_id='" + gallery_id + "' ");
            ps.setInt(1, restaurant_id);
            ps.setInt(2, gallery_id);
            ps.execute();
            
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
	
	public int showImages(int id) 
	{
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_profile_id,restaurant_picture,restaurant_picture_name FROM restaurant_gallery WHERE restaurant_gallery_id='" + id + "'");

			while (rs.next()) 
			{
				if (id == rs.getInt(1))
				{
					System.out.println("Imagen: " + rs.getString(3));
				}
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
		return id;
	}
	
	public ArrayList<Gallery> showAllGallery(int id)
	{
		ArrayList<Gallery> gallery = new ArrayList<Gallery>();
		
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM restaurant_gallery WHERE restaurant_profile_id='" + id + "'");

			while (rs.next()) 
			{
				Gallery g = new Gallery();
				g.setId(rs.getInt(1));
				g.setRestaurant_id(rs.getInt(2));
				g.setPicture(rs.getBlob(3));
				g.setName(rs.getString(4));
				gallery.add(g);
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
		return gallery;
	}
}
