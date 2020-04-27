package com.master4.services;

import com.master4.entities.Login;
import com.master4.entities.User;

public interface LoginService {

	public User validateUser(Login login);

}
