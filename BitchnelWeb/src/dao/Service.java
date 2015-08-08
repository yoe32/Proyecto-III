package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Service 
{
	private static Connection conexion = null;
    private final String url = "jdbc:mysql://localhost:3306/bitchneldb";
    private final String user = "root";
    private final String password = "root";
	
	protected void conectar()
	{
		try 
		{
           Class.forName("com.mysql.jdbc.Driver");
           conexion = DriverManager.getConnection(url, user, password); 
       } 
		
		catch (ClassNotFoundException e) 
		{
           e.printStackTrace();
       } 
		catch (SQLException e) 
		{
           e.printStackTrace();
       }
	}
	
	protected void desconectar()
	{
		try 
		{
           if (conexion != null) 
           {
               conexion.close();
           }
       } 
		
		catch (SQLException ex) 
		{
           ex.printStackTrace();
        }
	}
	
	protected Connection getConexion() 
	{
       return Service.conexion;
    }
	
	public static Connection getConnection() 
	{
       return conexion;
    }
}
