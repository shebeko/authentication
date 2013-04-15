package com.szybieka.authentication.service;

import com.szybieka.authentication.domain.User;

public interface LoginService  {
	
	/**
	 * Checks whether user with specified login exists
	 * @param login user name to log in
	 * @return true if user exists, false otherwise
	 */
	boolean userExists(String login);
	
	/**
	 * Seeks for user with corresponding login and password
	 * @param login user name to log in
	 * @param password password to log in
	 * @return User object if found, null otherwise
	 * @throws AuthenticationException 
	 */
	User findUser(String login, String password) throws AuthenticationException;
}
