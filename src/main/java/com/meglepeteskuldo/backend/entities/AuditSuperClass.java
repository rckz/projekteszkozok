/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author rckz
 */
@MappedSuperclass
public class AuditSuperClass implements Serializable{
    
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;
    
    @Getter
    @Setter    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @Getter
    @Setter
    private boolean isDeleted;
}
