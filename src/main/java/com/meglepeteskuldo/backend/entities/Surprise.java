/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.entities;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 *
 * @author rckz
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Surprise")
@RequiredArgsConstructor
public class Surprise extends AuditSuperClass implements Serializable {

    @Getter
    @Setter
    @NonNull
    private String productName;
    @Getter
    @Setter
    @NonNull
    private int price;
    @Getter
    @Setter
    private String color;
    @Getter
    @Setter
    private Consistency consistency;
    @Getter
    @Setter
    private String imageUrl;

//    public Surprise(String productName, int price, String color, Consistency consistency, String imageUrl) {
//        this.productName = productName;
//        this.price = price;
//        this.color = color;
//        this.consistency = consistency;
//        this.imageUrl = imageUrl;
//    }
    //    @Getter
//    @Setter
//    @OneToOne
//    private MOrder order;
}
