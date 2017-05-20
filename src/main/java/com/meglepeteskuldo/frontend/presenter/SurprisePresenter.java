package com.meglepeteskuldo.frontend.presenter;

import java.util.List;

import com.meglepeteskuldo.backend.entities.Consistency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.backend.services.SurpriseService;

@Service
public class SurprisePresenter {
	
	@Autowired
	SurpriseService ss;
	
	public List<Surprise> getAllSurprise(){
		return ss.findAll();
	}

	public List<Surprise> getFilteredSurprise(String name, String color, Consistency consistency, int price){
		return ss.getSupriseByEverything(name, color, consistency, price);
	}
}
