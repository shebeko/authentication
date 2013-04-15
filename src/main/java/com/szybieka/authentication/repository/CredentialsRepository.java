package com.szybieka.authentication.repository;

import com.szybieka.authentication.domain.User;

public interface CredentialsRepository {
	
	User findUser(String login, String password);
	
	User findUserByLogin(String login);
	
	void storeUser(User user);
}
