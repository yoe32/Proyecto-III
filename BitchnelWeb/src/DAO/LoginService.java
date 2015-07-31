package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginService extends Service
{
	public boolean login(String email, String password) 
	{
		boolean match = false;
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT restaurant_profile_id, restaurant_name, restaurant_email, restaurant_password FROM restaurant_profile");

			while (rs.next() && !match) 
			{
				if (email.equals(rs.getString(3)) && (password.equals(rs.getString(4)))) 
				{
					System.out.println("Welcome " + rs.getString(2));
					match = true;
				}
			}
			
			if(match == false)
			{
				System.out.println("Usuario o contrasena incorrectos");
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
}
