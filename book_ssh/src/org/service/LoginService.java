package org.service;

import org.dao.LoginDao;
import org.model.Login;

public class LoginService {
	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	public LoginDao getLoginDao() {
		return loginDao;
	}
	
	public Login checkLogin(String name, String password){
		return loginDao.checkLogin(name, password);
	}

}
