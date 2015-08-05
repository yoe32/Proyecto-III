package dao;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GalleryService extends Service
{
	public void addImg(int rest_id, int gallery_id, InputStream img, String name)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_gallery (restaurant_gallery_id,restaurant_profile_id,restaurant_picture,restaurant_picture_name)values(?,?,?,?)");
            ps.setInt(1, rest_id);
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
	
	public int showImages(int id) 
	{
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_profile_id,restaurant_picture, restaurant_picture_name FROM restaurant_gallery WHERE restaurant_profile_id='" + id + "'");

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
}
