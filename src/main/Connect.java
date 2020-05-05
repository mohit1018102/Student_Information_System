package main;

import java.sql.*;
public class Connect  {
	public Connection con;
	public PreparedStatement statement;
	public ResultSet result;
	public Connect() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		
	}
}
