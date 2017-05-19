package com.meglepeteskuldo.frontend.presenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meglepeteskuldo.backend.entities.MUser;
import com.meglepeteskuldo.backend.services.MUserService;
import com.meglepeteskuldo.errors.AlreadyExists;
import com.meglepeteskuldo.errors.UsernameOrPasswordMismatch;

@Service
public class UserPresenter {
	
	@Autowired
	private MUserService mus;

	public MUser login(String uName, String pwd) throws UsernameOrPasswordMismatch {
		return mus.userCanLogin(uName, pwd);		
	}

	public void register(String name, String pwd, String email, String bankacc) throws AlreadyExists {
		mus.registerNewUser(name, pwd, email, bankacc);
	}
	
	

}
