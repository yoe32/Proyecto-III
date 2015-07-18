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
            ps.setInt(7, restaurant.getPhone_i());
            ps.setInt(8, restaurant.getPhone_ii());
            ps.setInt(9, restaurant.getPhone_iii());
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

