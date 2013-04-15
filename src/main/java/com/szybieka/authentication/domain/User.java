package com.szybieka.authentication.domain;

public class User {
	
	private Integer id;
	
	private String login;
	private String password;
	private String language;
	
	public Integer getId() {
		return id;
	}
	
	public User setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getLogin() {
		return login;
	}
	
	public User setLogin(String login) {
		this.login = login;
		return this;
	}
	
	public String getPassword() {
		return password;
	}
	
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public User setLanguage(String locale) {
		this.language = locale;
		return this;
	}
	
	public boolean isNew() {
		return (this.id == null);
	}
}
