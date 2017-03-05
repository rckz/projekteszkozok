/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.services;

import com.meglepeteskuldo.backend.entities.Meglepetes;
import com.meglepeteskuldo.backend.repositories.MeglepetesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rckz
 */
@Service
@Transactional
public class MeglepetesService {

    @Autowired
    private MeglepetesRepository meglepetesRepository;

    public void save(Meglepetes meglepetes) {
        meglepetesRepository.save(meglepetes);
        System.out.println("ÁLLÍTÓLAG LEMENTŐDÖTT!");
    }
    public List<Meglepetes> findAll(){
        List<Meglepetes> target = new ArrayList<>();
        meglepetesRepository.findAll().forEach(target::add);
        return target;
    }

}
