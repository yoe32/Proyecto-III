package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Main.Restaurant;

public class RegisterService extends Service
{
	public void registerRestaurant(Restaurant restaurant)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_profile (restaurant_profile_id,restaurant_name,restaurant_email,restaurant_password,restaurant_description,restaurant_province,restaurant_location,restaurant_phone1,restaurant_phone2,restaurant_phone3,restaurant_schedule,restaurant_img)values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, restaurant.getId());
            ps.setString(2, restaurant.getName());
            ps.setString(3, restaurant.getEmail());
            ps.setString(4, restaurant.getPassword());
            ps.setString(5, restaurant.getDescription());
            ps.setString(6, restaurant.getProvince());
            ps.setString(7, restaurant.getLocation());
            ps.setInt(8, restaurant.getPhonei());
            ps.setInt(9, restaurant.getPhoneii());
            ps.setInt(10, restaurant.getPhoneiii());
            ps.setString(11, restaurant.getSchedule());
            ps.setBytes(12, restaurant.getImg());
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
