/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.entities.test;

import com.meglepeteskuldo.backend.entities.Consistency;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Laci
 */
public class ConsistencyTest1{
    
    String hig = "Híg";
    
    /**
     *
     */
    @Test
    public void testConsistencyType1(){
        System.out.println("Consistency enum test hig");
        assertEquals(hig, Consistency.HIG.toString());
    }
}
