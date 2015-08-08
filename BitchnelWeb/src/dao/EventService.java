package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Event;

public class EventService extends Service
{
	public void addEvent(int id, int restaurant_id, String name, String description, String contact)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("INSERT INTO restaurant_event (restaurant_event_id,restaurant_profile_id,event_name,event_description,event_contact)values(?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setInt(2, restaurant_id);
            ps.setString(3, name);
            ps.setString(4, description);
            ps.setString(5, contact);
            ps.executeUpdate();
            
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
	
	public void deleteEvent(int restaurant_id, int restaurant_event_id)
	{
		conectar();
		
		try {
			PreparedStatement ps = getConexion().prepareStatement("DELETE FROM restaurant_event WHERE restaurant_profile_id='" + restaurant_id + "'  AND restaurant_event_id='" + restaurant_event_id + "' ");
            ps.setInt(1, restaurant_id);
            ps.setInt(2, restaurant_event_id);
            ps.execute();
            
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
	}
	
	public ArrayList<Event> showAllEvents(int id)
	{
		ArrayList<Event> event = new ArrayList<Event>();
		
		conectar();

		try 
		{
			Statement st = null;
			st = getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM restaurant_event WHERE restaurant_profile_id='" + id + "'");

			while (rs.next()) 
			{
				Event e = new Event();
				e.setId(rs.getInt(1));
				e.setRestaurant_id(rs.getInt(2));
				e.setName(rs.getString(3));
				e.setDescription(rs.getString(4));
				e.setContact(rs.getString(5));
				event.add(e);
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
		return event;
	}
}
