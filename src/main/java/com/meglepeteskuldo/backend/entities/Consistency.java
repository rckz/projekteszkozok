/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.entities;

import java.io.Serializable;

/**
 *
 * @author rckz
 */
public enum Consistency implements Serializable{
    HIG,SZILARD;

    @Override
    public String toString() {
        if(this.name().equals("HIG")){
            return "Híg";
        }else{
            return "Szilárd";
        }
    }
}
