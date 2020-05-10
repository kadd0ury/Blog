package com.master4.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.master4.entities.User;

public class PermissionInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	HttpSession session;

	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		User authUser = (User)request.getSession(false).getAttribute("userAuth");

		if (authUser.getRole().equals("Visitor")) {
			
			response.sendRedirect(request.getContextPath() + "/403");

		}

		return true;

	}
}
