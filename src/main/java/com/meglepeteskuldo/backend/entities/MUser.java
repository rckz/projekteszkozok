/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

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
    private String email;
    @Getter
    @Setter
    private String address;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @Getter
    @Setter
    List<MOrder> orders;
}
