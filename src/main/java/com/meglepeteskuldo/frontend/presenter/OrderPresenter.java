package com.meglepeteskuldo.frontend.presenter;

import com.meglepeteskuldo.backend.entities.MOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meglepeteskuldo.backend.entities.MUser;
import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.backend.services.MOrderService;

import java.util.List;

@Service
public class OrderPresenter {
	
	@Autowired
	private MOrderService mos;
	
	public MUser sendOrder(MUser user, Surprise s, String address, String msg){
		return mos.placeOrder(user, s, address, msg);
	}

//	public List<MOrder> findOrdersByUser(MUser user){
//		return mos.getOrderByUser(user);
//	}
}
