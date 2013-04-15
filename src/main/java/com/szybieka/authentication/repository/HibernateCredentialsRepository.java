package com.szybieka.authentication.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.szybieka.authentication.domain.User;

public class HibernateCredentialsRepository implements CredentialsRepository {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateCredentialsRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public User findUser(String login, String password) {
		
		User user = (User)(sessionFactory.getCurrentSession().createQuery("from User user where user.login like :login " +
				"and user.password like :password")
				.setString("login", login)
				.setString("password", password).uniqueResult());
		return user;
	}

	@Transactional(readOnly = true)
	public User findUserByLogin(String login) {
		User user = (User)sessionFactory.getCurrentSession().createQuery("from User user where user.login like  :login")
				.setString("login", login).uniqueResult();
		return user;
	}
	
	@Transactional
	public void storeUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		session.flush();
	}
	
}
