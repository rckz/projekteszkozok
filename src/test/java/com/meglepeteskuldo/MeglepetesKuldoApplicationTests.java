package com.meglepeteskuldo;

import com.meglepeteskuldo.backend.entities.Meglepetes;
import com.meglepeteskuldo.backend.services.MeglepetesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeglepetesKuldoApplicationTests {

    @Autowired
    MeglepetesService meglepetesService;

    @Test
//    @Ignore
    public void contextLoads() {
        meglepetesService.save(new Meglepetes("SHIT", 12));
        meglepetesService.findAll().get(0).getProductName();
    }

}
