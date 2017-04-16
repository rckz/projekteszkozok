package com.meglepeteskuldo;

import com.meglepeteskuldo.backend.entities.Surprise;
import com.meglepeteskuldo.backend.services.SurpriseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeglepetesKuldoApplicationTests {

    @Autowired
    SurpriseService supriseService;

    @Test
//    @Ignore
    public void contextLoads() {
        supriseService.save(new Surprise("SHIT", 12));
        System.out.println(supriseService.findAll().get(0).getProductName());        
    }

}
