package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Main.Restaurant;

public class RestaurantService extends Service
{
	public void registerRestaurant(Restaurant restaurant)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_profile (restaurant_profile_id,restaurant_name,restaurant_email,restaurant_password,restaurant_description,restaurant_location,restaurant_img)values(?,?,?,?,?,?,?)");
            ps.setInt(1, restaurant.getRestaurant_profile_id());
            ps.setString(2, restaurant.getRestaurant_name());
            ps.setString(3, restaurant.getRestaurant_email());
            ps.setString(4, restaurant.getRestaurant_password());
            ps.setString(5, restaurant.getRestaurant_description());
            ps.setString(6, restaurant.getRestaurant_location());
            ps.setBytes(7, restaurant.getRestaurant_img());
            ps.executeUpdate();
            
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
	
	
//	public void registerNormal(Normal normal)
//	{
//		conectar();
//		
//		try {
//			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO USUARIO (ID,ROOT,NAME,PASS,EMAIL)values(?,?,?,?,?)");
//            ps.setInt(1, normal.getId());
//            ps.setInt(2, normal.getRoot());
//            ps.setString(3, normal.getName());
//            ps.setString(4, normal.getPass());
//            ps.setString(5, normal.getEmail());
//            ps.executeUpdate();
//            
//            if (ps != null) {
//                ps.close();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//        desconectar();
//	}
//	
//	
//	public void showUsers()
//	{
//		conectar();
//		
//		try {
//            Statement st = null;
//            st = getConexion().createStatement();
//            ResultSet rs = st.executeQuery("SELECT ID, ROOT, NAME, PASS, EMAIL FROM USUARIO");
//            
//            while (rs.next()) 
//            {
//            	System.out.println("==================================================");
//                System.out.println("ID: " + rs.getInt(1));
//                System.out.println("ROOT STATE: " + rs.getInt(2));
//                System.out.println("NAME: " + rs.getString(3));
//                System.out.println("PASS: " + rs.getString(4));
//                System.out.println("EMAIL:" + rs.getString(5));
//                System.out.println("==================================================");
//            }
//
//            if (rs != null) {
//                rs.close();
//            }
//            if (st != null) {
//                st.close();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//        desconectar();
//	}
//	
//	
//	public void compareCredentials(String username, String password)
//	{
//		
//		boolean entro = false;
//		conectar();
//		
//		try {
//            Statement st = null;
//            st = getConexion().createStatement();
//            ResultSet rs = st.executeQuery("SELECT ID, ROOT, NAME, PASS, EMAIL FROM USUARIO");
//            
//            while (rs.next() && !entro) 
//            {
//            
//            	if (username.equals(rs.getString(3)) && (password.equals(rs.getString(4))))
//        		{
//        			System.out.println("Welcome " + username );
//        			entro =true;
//        			
//        			if(rs.getInt(2) == 1)
//        			{
//        				System.out.println("Tipo de Usuario: restaurantistrador");
//        			}
//        			
//        			else
//        			{
//        				System.out.println("Tipo de Usuario: Normal");
//        			}
//        		}
//                
//            }
//            
//            if (entro == false)
//            {
//            	System.out.println("Usuario o contrasena incorrectos" );
//            }
//            
//            
//            if (rs != null) 
//            {
//                rs.close();
//            }
//            
//            if (st != null) 
//            {
//                st.close();
//            }
//            
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//        desconectar();
//	}
//	
//	
//	public void compareCredentials2()
//	{
//		String username = "";
//		String password = "";
//		
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("Digite su nombre de Usuario: ");
//		username = scan.next();
//		System.out.println("Digite su contrasena: ");
//		password = scan.next();
//		scan.close();
//		
//		
//		boolean entro = false;
//		conectar();
//		
//		try {
//            Statement st = null;
//            st = getConexion().createStatement();
//            ResultSet rs = st.executeQuery("SELECT ID, ROOT, NAME, PASS, EMAIL FROM USUARIO");
//            
//            while (rs.next() && !entro) 
//            {
//            
//            	if (username.equals(rs.getString(3)) && (password.equals(rs.getString(4))))
//        		{
//        			System.out.println("Welcome " + username );
//        			entro =true;
//        			
//        			if(rs.getInt(2) == 1)
//        			{
//        				System.out.println("Tipo de Usuario: restaurant");
//        			}
//        			
//        			else
//        			{
//        				System.out.println("Tipo de Usuario: Normal");
//        			}
//        		}
//                
//            }
//            
//            if (entro == false)
//            {
//            	System.out.println("Usuario o contrasena incorrectos" );
//            }
//            
//            
//            if (rs != null) 
//            {
//                rs.close();
//            }
//            
//            if (st != null) 
//            {
//                st.close();
//            }
//            
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//        desconectar();
//	}
}
