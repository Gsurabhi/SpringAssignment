package com.bitwise.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping (value = "/login", method = RequestMethod.GET)
	public String displayLogin (ModelMap model) {
		UserBean user = new UserBean ();
		model.addAttribute("title", "Login");
		model.addAttribute("user", user);
		model.addAttribute("login", "true");
		
		return ("index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String auth(ModelMap model, @ModelAttribute("user") UserBean user, BindingResult result, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		String url = "index";
		url = handleUserInput(model, user, result, url, request, response);
		return (url);
	}

	private String handleUserInput(ModelMap model, UserBean user, BindingResult result, String url,
			HttpServletRequest request, HttpServletResponse response) {
		UserValidator validator = new UserValidator();
		validator.validate(user, result);
		url = authenticateUser(model, user, result, url, request, response);
		return url;
	}

	private String authenticateUser(ModelMap model, UserBean user, BindingResult result, String url,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			url = "index";
		}
		if (new Users().getUsers().containsKey(user.getUsername()) && new Users().getUsers().containsValue(user.getPassword())) {
			System.out.println("hellooo ");
			url = "redirect:/products/store";
			startSession(user, request, response);
		} 
			else {
			model.addAttribute("error", "invalidUser");
		}
		return url;
	}

	private void startSession(UserBean user, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);

		session.setAttribute("username", user.getUsername());
		session.setAttribute("sessID", session.getId());
		session.setMaxInactiveInterval(1000);
		Cookie cookie = new Cookie("sessID", session.getId());
		cookie.setMaxAge(10000);
		response.addCookie(cookie);
		initStoreItems(request);
	}
	
	private void initStoreItems(HttpServletRequest req) {
		if (req.getSession(false).getAttribute("products") == null) {
			ProductBean products = new ProductBean();
			req.getSession(false).setAttribute("products", products);
		}
	}
	
	
}