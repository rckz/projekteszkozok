/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author rckz
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MUser")
public class MUser extends AuditSuperClass implements Serializable {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter

    private String password;
    @Getter
    @Setter
<<<<<<< HEAD:src/main/java/backend/entities/Meglepetes.java
    private String productName;
    
=======

    private String email;
    @Getter
    @Setter
    private String address;

    @OneToMany
>>>>>>> 9498d882295a88caa6fb9c00a478d285239f003a:src/main/java/com/meglepeteskuldo/backend/entities/MUser.java
    @Getter
    @Setter
    List<MOrder> orders;
}
