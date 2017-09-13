package com.avizva.DAO;

import com.avizva.Model.Users;

public interface UserDAO {
	public boolean saveUser(Users user);
	public boolean updateUser(Users user);
}
