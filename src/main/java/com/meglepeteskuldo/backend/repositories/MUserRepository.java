/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.repositories;

import com.meglepeteskuldo.backend.entities.MUser;

/**
 *
 * @author rckz
 */
public interface MUserRepository extends SuperRepository<MUser>{
    public MUser findByName(String name);
}
