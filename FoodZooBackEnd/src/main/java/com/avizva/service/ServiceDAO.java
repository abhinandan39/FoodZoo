package com.avizva.service;

import javax.servlet.http.HttpServletRequest;

import com.avizva.Model.Users;

public interface ServiceDAO {

	public boolean saveService(Users user);
	public boolean updateService(Users user);
	public boolean mailService(HttpServletRequest request);
	public boolean loginService(HttpServletRequest request);
	public boolean validity(String username, String password);
	public boolean deactivateService(String username);
	public Users viewUserService(String username);
	
}
