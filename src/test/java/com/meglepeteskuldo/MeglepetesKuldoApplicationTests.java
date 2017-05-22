package com.meglepeteskuldo;

import com.meglepeteskuldo.errors.AlreadyExists;
import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.backend.services.MOrderService;
import com.meglepeteskuldo.backend.services.MUserService;
import com.meglepeteskuldo.backend.services.SurpriseService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeglepetesKuldoApplicationTests {

    @Autowired
    SurpriseService supriseService;

    @Autowired
    MUserService mUserService;
    
    @Autowired
    MOrderService mOrderService;

    @Test
//    @Ignore
    @Transactional    
    public void contextLoads() {
        try {
            //        supriseService.save(new Surprise("SHIT", 12));
//        System.out.println(supriseService.findAll().get(0).getProductName());
//            mUserService.registerNewUser("anyad", "anyad", "anyad", "anyad");
            mUserService.registerNewUser("awdsd", "awddaw", "awdwd", "awdwad");
            System.out.println(mUserService.findAll().get(0).getName());

            supriseService.createNewSurprise("awdwdProduct", 5, "YELLOW", "HIG", "asdasd");
            System.out.println(supriseService.findAll().get(0).getProductName());
            
            mOrderService.placeOrder(mUserService.findAll().get(0), supriseService.findAll().get(0), "cim", "desc");
            
            System.out.println(mOrderService.findAll().get(0).getCustomer().getOrders());
            mOrderService.delete(mOrderService.findAll().get(0));
            System.out.println(mUserService.findAll().get(0).getOrders());
        } catch (AlreadyExists ex) {
            System.out.println("Elkapva");
        }

    }

}
