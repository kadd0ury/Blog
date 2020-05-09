package com.master4.Interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.master4.entities.User;

public class ArticleProhibit extends HandlerInterceptorAdapter {
	
	@Autowired
	HttpSession session ;
	
	String role ;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    
            throws Exception {
		
		   // System.out.print("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		
		 //User authUser= (User)session.getAttribute("userAuth");
		 
		 
		 //  System.out.print("role"+role);
		 //if (authUser != null ) { 
			//role = authUser.getRole() ;

		// }
		 
		// else {
			 
			// System.out.print("object authUser is null ");
		 //}
		 
		 if (role =="Visitor") {
			 
			 System.out.print("your role is "+role);
			 response.sendRedirect(request.getContextPath()+"/403");
			 
			
			 
			 
			 
		 }
		 
		 
		
		
		
		
		
		
		

		
		 
		return true;
  
	
	
	
	
	
	

}}
