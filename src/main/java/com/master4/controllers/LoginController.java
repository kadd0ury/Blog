package com.master4.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.master4.entities.Login;
import com.master4.entities.User;
import com.master4.services.LoginService;
import com.master4.services.UserService;;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;

	@Autowired
	UserService userservice;

	@Autowired
	LoginService loginservice;

	@GetMapping("/login")
	public String loginForm(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login/loginUser";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") Login login, BindingResult result, Model model,HttpServletRequest request) {
		if (result.hasErrors()) {
			System.out.println("bonjour login");
			return "login/loginUser";
		}

		String message = null;
		String var = null;
		User userEntry = loginservice.validateUser(login);
		// System.out.print(userEntry);

		if (userEntry != null) {

			//session.setAttribute("userAuth", userEntry);
			
			request.getSession(true).setAttribute("userAuth", userEntry);

			System.out.print(session.getAttribute("userAuth") + "session");

			var = "redirect:/article/";
		}

		else {
			message = "les informations d'authentification sont incorectes";
			model.addAttribute("message", message);
			System.out.print(session.getAttribute("userAuth") + "session");
			var = "login/loginUser";

		}
		return var;

	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession(true).setAttribute("userAuth", null);
		loginservice.setUserAuth();
		//session.setAttribute("userAuth", null);
		

		return "redirect:/login";

	}

	@GetMapping("/403")
	public String error() {

		return "Unauthorized/erreur403";
	}

}
