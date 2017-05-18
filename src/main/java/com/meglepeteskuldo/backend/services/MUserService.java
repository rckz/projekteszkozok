/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meglepeteskuldo.backend.services;

import com.meglepeteskuldo.errors.AlreadyExists;
import com.meglepeteskuldo.backend.entities.MUser;
import com.meglepeteskuldo.backend.repositories.MUserRepository;
import com.meglepeteskuldo.errors.UsernameOrPasswordMismatch;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rckz
 */
@Service
@Transactional
public class MUserService extends SuperService<MUser, MUserRepository> {

    public void registerNewUser(String name, String password, String email, String address) throws AlreadyExists {
        if (repository.findByName(name) == null) {
            MUser user = new MUser();
            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);
            user.setAddress(address);
            user.setOrders(new ArrayList<>());
            repository.save(user);
        }else{
            throw new AlreadyExists("");
        }
    }
    
    public boolean userCanLogin(String name,String password) throws UsernameOrPasswordMismatch{
        MUser found = repository.findByName(name);
        if(found == null || !found.getPassword().equals(password)){
            throw new UsernameOrPasswordMismatch();
        }
        return true;
    }

}
