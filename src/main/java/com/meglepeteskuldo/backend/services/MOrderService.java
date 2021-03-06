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

import java.util.List;

/**
 * @file
 * @author  rckz
 * @version 1.0
 *
 * @section DESCRIPTION
 *
 * A rendelésekkel kapcsolatos háttérfolyamatokra szolgál ez az osztály.
 */
@Service
@Transactional
public class MOrderService extends SuperService<MOrder, MOrderRepository> {

    @Autowired
    private MUserService mUserService;
    
    @Autowired
    private SurpriseService surpriseService;

    /**
     * Egy rendelés feladására szolgál.
     *
     * Frissíti az összes, a rendeléshez tartozó entitást.
     *
     * @param customer
     * @param surprise
     * @param address
     * @param description
     * @return a managelt customer objekt
     */
    public MUser placeOrder(MUser customer, Surprise surprise, String address, String description) {
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
        return customer;
    }

    /**
     * Egy rendelés törlését végzi el.
     *
     * Frissíti az összes, a rendeléshez tartozó entitást.
     *
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

//    public List<MOrder> getOrderByUser(MUser user){
//        return repository.findByCustomer(user);
//    }
}
