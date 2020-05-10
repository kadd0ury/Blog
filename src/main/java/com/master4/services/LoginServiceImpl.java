package com.master4.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master4.entities.Login;
import com.master4.entities.User;

@Service
public class LoginServiceImpl implements LoginService{
	
	User iSuser = null ;
	@Autowired
	UserService userservice;

	@Override
	@Transactional
	public User validateUser(Login login) {
		List <User>listeusers = userservice.getAllUsers();
		
		for (User user : listeusers) {
			
			//System.out.println("username :"+user.getNom()+" Password "+user.getPassword());
			
			if (user.getNom().equals(login.getUsername()) && user.getPassword().equals(login.getPassword())) {
				iSuser = user;
				
			}	
		}
		
		//System.out.print("objet return"+iSuser);
		return iSuser;
		
	
	}
	
	public void setUserAuth() {
		
		iSuser=null ;
		
		
	}
	
}
