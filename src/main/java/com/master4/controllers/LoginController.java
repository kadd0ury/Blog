package com.master4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.master4.entities.Login;
import com.master4.entities.User;
import com.master4.services.LoginService;
import com.master4.services.UserService;;
@Controller
public class LoginController {
	
	String username ;

	
	@Autowired
	UserService userservice;
	
	@Autowired
	LoginService loginservice;
	
	
	
	
	@GetMapping("/login")
	public String loginForm(Model model){	
	Login login =new Login ();
	model.addAttribute("login",login);
	return "login/loginUser";
	}
	
	
	@PostMapping("/login")
	public String login (@ModelAttribute("login") Login login,Model model){
		
		String message  = null;
		String var  = null ;
		User userEntry = loginservice.validateUser(login);
		System.out.print(userEntry);
		
		if (userEntry!=null ) {
			var = "redirect:/article/";
		}
		
		else {
	
		message ="les informations d'authentification sont incorectes";
		model.addAttribute("message",message);
			
		var = "login/loginUser";
		
		}
		return var;
		
	}

	
	
	
	


}
