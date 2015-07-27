package com.reddonor.services;

import java.sql.SQLException;

import com.reddonor.entity.LoginBean;

public interface RedDonorService {
	public void register(int drMobile, int drPswd, String drEmail, int drciId, int drArId, int drCoId, int drBgId, String drFirstName, String drLastName);
	public void isAvailable(int drMobile);
	public LoginBean login(int drMobile,String drPswd) throws SQLException;
	public String generateCsrfToken(int drMobile, String drPswd);
	public void isValidSession(String session);
}
