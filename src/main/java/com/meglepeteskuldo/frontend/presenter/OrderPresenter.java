package com.meglepeteskuldo.frontend.presenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meglepeteskuldo.backend.entities.MUser;
import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.backend.services.MOrderService;

@Service
public class OrderPresenter {
	
	@Autowired
	private MOrderService mos;
	
	public void sendOrder(MUser user, Surprise s, String address, String msg){
		mos.placeOrder(user, s, address, msg);
	}
}
