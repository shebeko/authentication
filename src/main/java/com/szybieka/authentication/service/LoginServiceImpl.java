package com.szybieka.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szybieka.authentication.domain.User;
import com.szybieka.authentication.repository.CredentialsRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	CredentialsRepository repository;
	
	@Override
	public boolean userExists(String login) {
		return (repository.findUserByLogin(login) != null) ? true : false;
	}

	@Override
	public User findUser(String login, String password) throws AuthenticationException {
		User user = repository.findUser(login, password);
		if (user == null) throw new AuthenticationException("Incorrect user name and/or password");
		return user;
	}
	
}
