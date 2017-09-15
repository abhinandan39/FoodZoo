package com.avizva.DAO;

import com.avizva.Model.Users;

public interface UserDAO {
	
	public boolean saveUser(Users user);
	public boolean updateUser(Users user);
	public boolean valid(String username, String password);
	public boolean deactivateUser(String username);
	public Users viewUser(String username);
	public String securityque(String username);
	public boolean securityans(String securityans,String username);
	public boolean updatepassword(String username, String password);
	public boolean existUser(String username);
}
