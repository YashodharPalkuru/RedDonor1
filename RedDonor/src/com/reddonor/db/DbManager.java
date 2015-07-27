package com.reddonor.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;

public class DbManager 
{
	// Replace it wid hibernate or ibatis
	private static Connection connection;
	private DbManager()
	{
	}
    public static synchronized Connection getConnection() throws SQLException
    {
    	// Replace it with spring AOP
    	Logger log = new Log4JLogger().getLogger();
    	if(connection == null || connection.isClosed())
    	{
    		try 
    		{
				String url = "jdbc:mysql://localhost:3306/RedDonorDB";
				Class.forName("com.mysql.jdbc.Driver");
				log.info("Driver Loaded");
				connection = DriverManager.getConnection(url, "root","");
			} 
    		catch (Exception e) 
    		{ 
				e.printStackTrace();
			}
    	}
        return connection;
    }
}