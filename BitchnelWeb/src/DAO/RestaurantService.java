package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.Restaurant;

public class RestaurantService extends Service
{
	public int getIdInfo(String email) 
	{
		int id = 0;
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_profile_id, restaurant_email FROM restaurant_profile WHERE restaurant_email='" + email + "'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(2)))
				{
					System.out.println("Desde restaurant service " + rs.getInt(1));
					id = rs.getInt(1);
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
	
	public String getNameInfo(String email) 
	{
		String name = "";
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_name, restaurant_email FROM restaurant_profile WHERE restaurant_email='" + email + "'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(2)))
				{
					System.out.println("Desde restaurant service " + rs.getString(1));
					name = rs.getString(1);
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
		return name;
	}
	
	public String getDescriptionInfo(String email) 
	{
		String description = "";
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_description, restaurant_email FROM restaurant_profile WHERE restaurant_email='" + email + "'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(2)))
				{
					System.out.println("Desde restaurant service " + rs.getString(1));
					description = rs.getString(1);
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
		return description;
	}
	
	public String getProvinceInfo(String email) 
	{
		String province = "";
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_province, restaurant_email FROM restaurant_profile WHERE restaurant_email='" + email + "'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(2)))
				{
					System.out.println("Desde restaurant service " + rs.getString(1));
					province = rs.getString(1);
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
		return province;
	}
	
	public String getLocationInfo(String email) 
	{
		String location = "";
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_location, restaurant_email FROM restaurant_profile WHERE restaurant_email='" + email + "'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(2)))
				{
					System.out.println("Desde restaurant service " + rs.getString(1));
					location = rs.getString(1);
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
		return location;
	}
	
	public int getPhone1Info(String email) 
	{
		int phonei = 0;
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_phone1, restaurant_email FROM restaurant_profile WHERE restaurant_email='" + email + "'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(2)))
				{
					System.out.println("Desde restaurant service " + rs.getInt(1));
					phonei = rs.getInt(1);
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
		return phonei;
	}
	
	public int getPhone2Info(String email) 
	{
		int phoneii = 0;
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_phone2, restaurant_email FROM restaurant_profile WHERE restaurant_email='" + email + "'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(2)))
				{
					System.out.println("Desde restaurant service " + rs.getInt(1));
					phoneii = rs.getInt(1);
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
		return phoneii;
	}
	
	public int getPhone3Info(String email) 
	{
		int phoneiii = 0;
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_phone3, restaurant_email FROM restaurant_profile WHERE restaurant_email='" + email + "'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(2)))
				{
					System.out.println("Desde restaurant service " + rs.getInt(1));
					phoneiii = rs.getInt(1);
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
		return phoneiii;
	}
	
	public String getScheduleInfo(String email) 
	{
		String schedule = "";
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_schedule, restaurant_email FROM restaurant_profile WHERE restaurant_email='" + email + "'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(2)))
				{
					System.out.println("Desde restaurant service " + rs.getString(1));
					schedule = rs.getString(1);
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
		return schedule;
	}
	
	public byte[] getImgInfo(String email) 
	{
		byte[] img = {0x00,0x00,0x00,0x00};
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_img, restaurant_email FROM restaurant_profile WHERE restaurant_email='" + email + "'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(2)))
				{
					System.out.println("Desde restaurant service " + rs.getBytes(1));
					img = rs.getBytes(1);
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
		return img;
	}
	
	public void uploadProfileImage()
	{
		
	}
	
	public void updateName(Restaurant restaurant)
	{
		conectar();

		try {
			PreparedStatement ps = getConexion().prepareStatement("UPDATE restaurant_profile SET ");
			ps.setInt(1, restaurant.getId());
			ps.setString(2, restaurant.getName());
			ps.executeUpdate();

			if (ps != null) {
				ps.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		desconectar();
	}

	public void updateEmail()
	{

	}

	public void updatePassword()
	{

	}

	public void updateDescription()
	{

	}

	public void updateProvince()
	{

	}

	public void updateLocation()
	{

	}

	public void updatePhonei()
	{

	}

	public void updatePhoneii()
	{

	}

	public void updatePhoneiii()
	{

	}

	public void updateSchedule()
	{

	}

	public void updateImg()
	{

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