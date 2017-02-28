/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.repositories;

import backend.entities.AuditSuperClass;
import backend.entities.Meglepetes;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rckz
 */
public interface MeglepetesRepository extends CrudRepository<Meglepetes, AuditSuperClass> {
    
}
