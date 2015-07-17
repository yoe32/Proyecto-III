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
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_profile (restaurant_profile_id,restaurant_name,restaurant_email,restaurant_password,restaurant_description,restaurant_location,restaurant_phone_i,restaurant_phone_ii,restaurant_phone_iii, restaurant_img)values(?,?,?,?,?,?,?,?,?,?)");
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
	public void insertMenu(Menu menu){
		
		conectar();
		
		try{
		PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_product (menu_product,menu_descripcion,menu_img)values(?,?,?)");
		ps.setString(1, menu.getMenu_Product());
		ps.setString(2,menu.getMenu_Descripcion());
		ps.setBytes(3, menu.getMenu_Img());
		  ps.executeUpdate();
          
          if (ps != null) {
              ps.close();
          }

      } catch (SQLException e) {
          e.printStackTrace();
      }
      
      desconectar();
	}
	

public void insertEvent(Event event){
	
	conectar();
	
	try{
	PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_event (event_name,event_descripcion,event_contact)values(?,?,?)");
	ps.setString(1, event.getEvent_Name());
	ps.setString(2,event.getEvent_Descripcion());
	ps.setString(3, event.getEvent_Contact());
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
	public void login(String email, String password)
	{
		conectar();
		
		try {
            Statement st = null;
            st = getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT restaurant_profile_id, restaurant_email, restaurant_password FROM restaurant_profile");
            
            while (rs.next()) 
            {
            
            	if (email.equals(rs.getString(3)) && (password.equals(rs.getString(4))))
        		{
        			System.out.println("Welcome " + email );
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
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
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

