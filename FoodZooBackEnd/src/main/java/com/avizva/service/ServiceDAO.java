package com.avizva.service;

import javax.servlet.http.HttpServletRequest;

import com.avizva.model.ShippingAddress;
import com.avizva.model.Users;

public interface ServiceDAO {

	/**
	 * saveService method called for saving the user data after sign up
	 * @param user 
	 * @return true or false
	 */
	public boolean saveService(Users user);
	/**
	 * updateService method called to update the data of already existing user
	 * @param user
	 * @return true or false
	 */
	public boolean updateService(Users user);
	/**
	 * mailService method to provide the mail service to the user on the contact page
	 * when user submits the for it sends a confirmation mail to the particular user
	 * @param request
	 * @return true or false
	 */
	public boolean mailService(HttpServletRequest request);
	
	/**
	 * loginService method called for providing the login functionality
	 * takes the user input and pass it to validity method
	 * 
	 * @param request
	 * @return true or false
	 */
	public boolean loginService(HttpServletRequest request);
	
	/**
	 * validity method further takes the user credentials and pass it for verfication
	 * if result comes out to be true then user is logged in else not
	 * @param username
	 * @param password
	 * @return true or false
	 */
	public boolean validity(String username, String password);
	
	/**
	 * deactivateService method for performing deactivation of the user with its primary key username
	 * @param username
	 * @return true or false
	 */
	public boolean deactivateService(String username);
	public Users viewUserService(String username);
	/**
	 * questionService method takes the question related to the particular user and pass it for validating
	 * @param username
	 * @return true or false
	 */
	public String questionService(String username);
	
	/**
	 * answerService method for checking the answer entered by user matches with the existing one
	 * @param securityans
	 * @param username
	 * @return true or false
	 */
	public boolean answerService(String securityans,String username);
	
	/**
	 * passwordService method for updating the password 
	 * @param username
	 * @param password
	 * @return true or false
	 */
	public boolean passwordService(String username, String password);
	
	/**
	 * existUserService method to check if user exists or not
	 * @param username
	 * @return true or false
	 */
	public boolean existUserService(String username);
	
	
}
