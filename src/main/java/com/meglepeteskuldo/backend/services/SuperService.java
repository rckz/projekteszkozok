/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.services;

import com.meglepeteskuldo.backend.entities.AuditSuperClass;
import com.meglepeteskuldo.backend.repositories.SuperRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @file
 * @author  rckz
 * @version 1.0
 *
 * @section DESCRIPTION
 *
 * Minden service ebből az osztályból származik, tartalmazza azokat a műveleteket, amit minden servicenek tudnia kell.
 */
public abstract class SuperService <E extends AuditSuperClass, R extends SuperRepository<E>>{
    @Autowired
    protected R repository;

    /**
     * Elementi az adatbázisba a megadott entitást
     * @param entity
     */
    public void save(E entity) {
        repository.save(entity);        
    }

    /**
     * Visszaadja az összes entitást
     * @return entitások egy listája
     */
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
    public void delete(E e){
        repository.delete(e);
    }
    public boolean exists(Long id){
        return repository.exists(id);
    }    
}
