package com.avizva.DAO;

import com.avizva.Model.Users;

public interface UserDAO {
	
	/**
	 * saveUser method called for saving the user data after sign up.This method
	 * will get the control from the service method not from the controller directly.
	 * @param user:object of class user contains data of user
	 * @return true or false
	 */
	public boolean saveUser(Users user);
	/**
	 * updateUser method called to update the data of already existing user.This method
	 * will get the control from the service method not from the controller directly.
	 * @param user  :object of class user contains data of user
	 * @return true or false
	 */
	public boolean updateUser(Users user);
	/**
	 * valid method called to validate the username and password of a user for login.This method
	 * will get the control from the service method not from the controller directly.
	 * @param username :username entered by the user at the time of login
	 * @param password :password entered by the user at the time of login
	 * @return true or false
	 */
	public boolean valid(String username, String password);
	/**
	 * deactivateUser method for performing deactivation of the user with its primary key username
	 * This method will get the control from the service method not from the controller directly.
	 * @param username
	 * @return true or false
	 */
	public boolean deactivateUser(String username);
	/**
	 * viewUser method for fetching the username for a particular session
	 * 
	 * 
	 * */
	public Users viewUser(String username);
	/**
	 * securityque method for fetching security question for a particular user.
	 * It will get control from the service method not from the controller directly. 
	 * @param username : username for a particular session.
	 * @return string 
	 */
	public String securityque(String username);
	/**
	 * securityans method for validating security answer for a particular user's security question.
	 * It will get control from the service method not from the controller directly. 
	 * @param username : username for a particular session.
	 * @param securityans: security answer entered by the user for a particular session. 
	 * @return true or false 
	 */
	public boolean securityans(String securityans,String username);
	/**
	 * updatepassword method is for updating password for a particular user.
	 * It will get control from the service method not from the controller directly.
	 * @param username:username for a particular session.
	 * @param password: new password given by the user.
	 * @return true or false
	 */
	public boolean updatepassword(String username, String password);
}
