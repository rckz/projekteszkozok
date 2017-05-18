package com.meglepeteskuldo.frontend.presenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meglepeteskuldo.AlreadyExists;
import com.meglepeteskuldo.backend.services.MUserService;

@Service
public class UserPresenter {
	
	@Autowired
	private MUserService mus;

	public void login(String uName, String pwd) {
		//A userserviceben kéne valami ellenőrzést végezni, hogy van-e ilyen felhasználó
		//mus.login(uName, pwd);		
	}

	public void register(String name, String pwd, String email, String bankacc) throws AlreadyExists {
		mus.registerNewUser(name, pwd, email, bankacc);
	}
	
	

}
