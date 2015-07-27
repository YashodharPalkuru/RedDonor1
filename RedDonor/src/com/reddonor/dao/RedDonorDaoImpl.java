package com.reddonor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.reddonor.db.DbManager;



public class RedDonorDaoImpl implements RedDonorDao{

	@Override
	public void register(int drMobile, int drPswd, String drEmail, int drciId,
			int drArId, int drCoId, int drBgId, String drFirstName,
			String drLastName) {
		
	}

	@Override
	public void isAvailable(int drMobile) {
		
	}

	@Override
	public boolean login(int drMobile, String drPswd) throws SQLException
	{
		
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try
        {
        conn = DbManager.getConnection();
        ps = conn.prepareStatement("select count(*) from donor_login where dl_mobile = ? and dl_pswd = ?");
        ps.setInt(1, drMobile);
        ps.setString(2, drPswd);
        rs = ps.executeQuery();
        if(rs.next())
        {
            if(rs.getInt(1) > 0)
            {
            	return Boolean.TRUE;
            }
            else
            {
            	return Boolean.FALSE;
            }
        }
        }
        catch(SQLException e)
        {
            throw new SQLException(e);	
        }
		return Boolean.FALSE;
	}

	@Override
	public void insertCsrfToken(int drMobile, String drPswd, String csrfToken) throws SQLException
	{
        PreparedStatement ps = null;
        Connection conn = null;

        conn = DbManager.getConnection();
        ps = conn.prepareStatement("update donor_login set dl_csrf_token = ? where dl_mobile = ? and dl_pswd = ?");
        ps.setString(1, csrfToken);
        ps.setInt(2, drMobile);
        ps.setString(3, drPswd);
        
        if(ps.executeUpdate() > 0)
        {
        	System.out.println("csrf token inserted");
        }
        else
        {
        	throw new SQLException();
        }
       
	}
    
}
