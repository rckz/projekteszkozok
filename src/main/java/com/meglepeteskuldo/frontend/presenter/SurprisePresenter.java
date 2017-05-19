package com.meglepeteskuldo.frontend.presenter;

import java.util.List;

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
}
