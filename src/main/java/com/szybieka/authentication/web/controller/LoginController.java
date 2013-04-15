package com.szybieka.authentication.web.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.szybieka.authentication.domain.User;
import com.szybieka.authentication.service.AuthenticationException;
import com.szybieka.authentication.service.LoginService;

/**
 * Handles requests for the application login page.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private static final String ACCOUNT_ATTRIBUTE = "account";
	private static final String LOCALE = "locale";
	private static final String LANGUAGE= "language";
	
	@RequestMapping(method = RequestMethod.POST)
	public String postLogin(@RequestParam("login")String login, @RequestParam("password")String password,
			@RequestParam("language") String language, Model model, RedirectAttributes redirect) {
		try {
			User user = loginService.findUser(login, password);
			model.addAttribute(ACCOUNT_ATTRIBUTE, user);
			String currentLanguage;
			// Language wasn't chosen
			if (language.isEmpty()) {
				// If language field is empty, set currentLanguage value to 'ru'
				currentLanguage = (!user.getLanguage().isEmpty()) ? user.getLanguage() : "ru";			
			} else {
				currentLanguage = language;
			} 
			model.addAttribute(LANGUAGE, currentLanguage);
			model.addAttribute(LOCALE, getLocaleString(currentLanguage));
			return "welcome";
		} catch (AuthenticationException ae) {
			redirect.addFlashAttribute("exception", ae);
			return "redirect:/";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLogin(Locale locale, Model model) {
		return "login";
	}
	
	private String getLocaleString(String language) {
		String locale;
		if (language.equals("by")) {
			locale = "by_BY";
		} else if (language.equals("en")) {
			locale = "en_US";
		} else locale = "ru_RU";
		return locale;
	}
	
	
	
}
