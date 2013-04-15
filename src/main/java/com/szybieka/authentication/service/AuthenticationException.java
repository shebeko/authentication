package com.szybieka.authentication.service;

/**
 * Thrown when login or password are incorrect
 * 
 */
@SuppressWarnings("serial")
public class AuthenticationException extends Exception {
	
	public AuthenticationException(String message) {
		super(message);
	}
}
