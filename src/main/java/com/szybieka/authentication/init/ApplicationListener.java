package com.szybieka.authentication.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.szybieka.authentication.domain.User;
import com.szybieka.authentication.repository.CredentialsRepository;

public class ApplicationListener implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx);
		
		CredentialsRepository repository = (CredentialsRepository)springContext.getBean("repo");
		User user = new User().setLogin("PainKiller").setPassword("123456").setLanguage("en");
		repository.storeUser(user);
		user = new User().setLogin("ru").setPassword("123").setLanguage("ru");
		repository.storeUser(user);
		user = new User().setLogin("en").setPassword("123").setLanguage("en");
		repository.storeUser(user);
		user = new User().setLogin("by").setPassword("123").setLanguage("by");
		repository.storeUser(user);
	}

}
