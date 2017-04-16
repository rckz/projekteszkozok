/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 *
 * @author rckz
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MOrder")
public class MOrder extends AuditSuperClass implements Serializable {

    @Getter
    @Setter
    @NonNull
    @ManyToOne
    private MUser customer;
    @Getter
    @Setter
    @NonNull
    @OneToOne
    private Surprise surprise;
    @Getter
    @Setter
    @NonNull
    private String address;
    @Getter
    @Setter
    private String description;
}
