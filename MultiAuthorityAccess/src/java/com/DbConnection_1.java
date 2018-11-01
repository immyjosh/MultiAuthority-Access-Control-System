package com;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PSC
 */
public class DbConnection_1
{
	static Connection con;
	public static Connection getconnection() throws ClassNotFoundException
	{   
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sharedauthority", "root","root");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return con;
	}

}
