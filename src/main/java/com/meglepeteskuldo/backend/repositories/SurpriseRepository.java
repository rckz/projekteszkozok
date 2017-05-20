/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.repositories;

import com.meglepeteskuldo.backend.entities.Consistency;
import com.meglepeteskuldo.backend.entities.Surprise;

import java.util.List;

/**
 *
 * @author rckz
 */
public interface SurpriseRepository extends SuperRepository<Surprise>{
    public Surprise findByProductName(String productName);
    public List<Surprise> findByProductNameLikeAndColorLikeAndConsistencyAndPrice(String productName, String color,
                                                                          Consistency consistency, int price);
}
