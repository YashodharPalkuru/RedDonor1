package com.reddonor.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;

import com.reddonor.dao.RedDonorDao;
import com.reddonor.entity.LoginBean;

public class RedDonorServiceImpl implements RedDonorService{
	
	private RedDonorDao redDonorDao;
	
	@Override
	public void isAvailable(int drMobile) {
		
	}

	@Override
	public LoginBean login(int drMobile, String drPswd) throws SQLException {
		
		LoginBean loginBean = new LoginBean();
		loginBean.setStatus(Boolean.FALSE);
		try
		{
		if(redDonorDao.login(drMobile, drPswd))
		{
			//create a csrf token
			String csrfToken = generateCsrfToken(drMobile, drPswd);
			redDonorDao.insertCsrfToken(drMobile, drPswd,csrfToken );
			loginBean.setCsrfToken(csrfToken);
			loginBean.setStatus(Boolean.TRUE);
		}
		}
		catch(SQLException e)
		{
			throw new SQLException(e);
		}
		return loginBean;
		
	}

	@Override
	public String generateCsrfToken(int drMobile, String drPswd)
	{
		return (drMobile+drPswd).hashCode()+"";
	}
	
	public RedDonorDao getRedDonorDao() {
		return redDonorDao;
	}

	public void setRedDonorDao(RedDonorDao redDonorDao) {
		this.redDonorDao = redDonorDao;
	}

	@Override
	public void isValidSession(String session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(int drMobile, int drPswd, String drEmail, int drciId,
			int drArId, int drCoId, int drBgId, String drFirstName,
			String drLastName) {
		// TODO Auto-generated method stub
		
	}


}
