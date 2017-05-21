/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.services;

import com.meglepeteskuldo.backend.entities.MOrder;
import com.meglepeteskuldo.backend.entities.MUser;
import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.backend.repositories.MOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rckz
 */
@Service
@Transactional
public class MOrderService extends SuperService<MOrder, MOrderRepository> {

    @Autowired
    private MUserService mUserService;
    
    @Autowired
    private SurpriseService surpriseService;

    /**
     * Megrendelés létrehozása
     * @param customer
     * @param surprise
     * @param address
     * @param description
     */
    public void placeOrder(MUser customer, Surprise surprise, String address, String description) {
        if (customer != null && surprise != null) {
            customer = mUserService.findOne(customer.getId());
            surprise = surpriseService.findOne(surprise.getId());
            MOrder order = new MOrder(customer,surprise,address,description);
            save(order);
            customer.getOrders().add(order);
            mUserService.save(customer);
//            surprise.setOrder(order);
            //surprise.getOrders().add(order);
            surpriseService.save(surprise);
        }
    }

    /**
     * Paraméterként megadott rendelés törlése
     * @param order
     */
    @Override
    public void delete(MOrder order){
        MUser customer = order.getCustomer();
        customer.getOrders().remove(order);
        mUserService.save(customer);
        Surprise surprise = order.getSurprise();
//        surprise.setOrder(order);
        //surprise.getOrders().remove(order);
        surpriseService.save(surprise);
        super.delete(order);
    }
}
