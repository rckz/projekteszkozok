/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
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
    private Date dateCreated;
    
    @Getter
    @Setter
    private boolean isDeleted;
}
