package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Main.Menu;
import Main.Restaurant;
import Main.Event;

public class RestaurantService extends Service
{
	public void registerRestaurant(Restaurant restaurant)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_profile (restaurant_profile_id,restaurant_name,restaurant_email,restaurant_password,restaurant_description,restaurant_location,restaurant_phone1,restaurant_phone2,restaurant_phone3, restaurant_img)values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, restaurant.getId());
            ps.setString(2, restaurant.getName());
            ps.setString(3, restaurant.getEmail());
            ps.setString(4, restaurant.getPassword());
            ps.setString(5, restaurant.getDescription());
            ps.setString(6, restaurant.getLocation());
            ps.setInt(7, restaurant.getPhonei());
            ps.setInt(8, restaurant.getPhoneii());
            ps.setInt(9, restaurant.getPhoneiii());
            ps.setBytes(10, restaurant.getImg());
            ps.executeUpdate();
            
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
	
	public boolean login(String email, String password) 
	{
		boolean match = false;
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_profile_id, restaurant_name, restaurant_email, restaurant_password FROM restaurant_profile");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(3)) && (password.equals(rs.getString(4)))) 
				{
					System.out.println("Welcome " + rs.getString(2));
					match = true;
				}
				else
				{
					System.out.println("Usuario o contrasena incorrectos");
					match = false;
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
		
		return match;
	}
	
	public void createMenu(Restaurant restaurant)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_profile (restaurant_profile_id,restaurant_name,restaurant_email,restaurant_password,restaurant_description,restaurant_location,restaurant_phone1,restaurant_phone2,restaurant_phone3, restaurant_img)values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, restaurant.getId());
            ps.setString(2, restaurant.getName());
            ps.setString(3, restaurant.getEmail());
            ps.setString(4, restaurant.getPassword());
            ps.setString(5, restaurant.getDescription());
            ps.setString(6, restaurant.getLocation());
            ps.setInt(7, restaurant.getPhonei());
            ps.setInt(8, restaurant.getPhoneii());
            ps.setInt(9, restaurant.getPhoneiii());
            ps.setBytes(10, restaurant.getImg());
            ps.executeUpdate();
            
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
	
	public void createEvent(Restaurant restaurant)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_profile (restaurant_profile_id,restaurant_name,restaurant_email,restaurant_password,restaurant_description,restaurant_location,restaurant_phone1,restaurant_phone2,restaurant_phone3, restaurant_img)values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, restaurant.getId());
            ps.setString(2, restaurant.getName());
            ps.setString(3, restaurant.getEmail());
            ps.setString(4, restaurant.getPassword());
            ps.setString(5, restaurant.getDescription());
            ps.setString(6, restaurant.getLocation());
            ps.setInt(7, restaurant.getPhonei());
            ps.setInt(8, restaurant.getPhoneii());
            ps.setInt(9, restaurant.getPhoneiii());
            ps.setBytes(10, restaurant.getImg());
            ps.executeUpdate();
            
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
}