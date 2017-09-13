package com.avizva.DAO;

import com.avizva.Model.Users;

public interface UserDAO {
	public boolean saveUser(Users user);
	public boolean updateUser(String username);
	public boolean valid(String username, String password);
	public boolean deactivateUser(String username);
	public Users viewUser(String username);
}
