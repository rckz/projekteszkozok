/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.services;

import com.meglepeteskuldo.errors.AlreadyExists;
import com.meglepeteskuldo.backend.entities.Consistency;
import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.backend.repositories.SurpriseRepository;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rckz
 */
@Service
@Transactional
public class SurpriseService extends SuperService<Surprise, SurpriseRepository>{    
    public void createNewSurprise(String productName,int price,String color,String consistency,String imageUrl) throws AlreadyExists{
        if (repository.findByProductName(productName) == null) {
            Surprise surprise = new Surprise(productName, price,color,Consistency.valueOf(consistency),imageUrl);
            repository.save(surprise);
        }else{
            throw new AlreadyExists();
        }
    }

    public List<Surprise> getSupriseByEverything(String name, String color, Consistency consistency, int price){
        return repository.findByProductNameLikeAndColorLikeAndConsistencyAndPrice(name, color, consistency, price);
    }
}
