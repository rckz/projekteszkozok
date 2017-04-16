/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.repositories;

import com.meglepeteskuldo.backend.entities.AuditSuperClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rckz
 */
@Repository
public interface SuperRepository<E extends AuditSuperClass> extends CrudRepository<E, Long>{
    
}
