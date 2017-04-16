/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.services;

import com.meglepeteskuldo.backend.entities.AuditSuperClass;
import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.backend.repositories.SuperRepository;
import com.meglepeteskuldo.backend.repositories.SurpriseRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rckz
 */

public abstract class SuperService <E extends AuditSuperClass, R extends SuperRepository<E>>{
    @Autowired
    private R repository;

    public void save(E entity) {
        repository.save(entity);        
    }
    public List<E> findAll(){
        List<E> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target;
    }
    public long count(){        
        return repository.count();
    }
    public E findOne(Long id){
        return repository.findOne(id);
    }
    public void delete(Long id){
        repository.delete(id);
    }
    public void delete(E e){
        repository.delete(e);
    }
    public boolean exists(Long id){
        return repository.exists(id);
    }
}
