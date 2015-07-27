package com.reddonor.dao;

import java.sql.SQLException;

public interface RedDonorDao {
    public void register(int drMobile, int drPswd, String drEmail, int drciId, int drArId, int drCoId, int drBgId, String drFirstName, String drLastName);
    public void isAvailable(int drMobile);
    public boolean login(int drMobile, String drPswd) throws SQLException;
    public void insertCsrfToken(int drMobile, String drPswd, String csrfToken) throws SQLException;
}
